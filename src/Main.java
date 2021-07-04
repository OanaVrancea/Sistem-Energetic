import action.Action;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import inputloader.Entity;
import inputloader.Input;
import outclasses.*;
import results.*;

public class Main {
    /***
     * implementarea algoritmului
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {


        File file = new File(args[0]);

        ObjectMapper objectMapper = new ObjectMapper();

        //citesc datele si le pun in clasa input
        Input input = objectMapper.readValue(file, Input.class);
        Entity entity = input.getInitialData();

        List<ConsumerOut> consumerOuts = new ArrayList<ConsumerOut>();
        List<DistributorOut> distributorOuts = new ArrayList<DistributorOut>();
        List<ProducerOut> producerOuts = new ArrayList<ProducerOut>();

        FactoryOutClasses factory = FactoryOutClasses.getInstance();

        //preiau toate datele pentru consuatori din input si le pun in
        //arrayul consumerOuts
        for (int i = 0; i < input.getInitialData().getConsumers().size(); i++) {
            ConsumerOut consumer = new ConsumerOut();
            //utilizez factory pentru a construi obiecte
            Common consumerFactory = FactoryOutClasses.createEntity(consumer,
                    input.getInitialData().getConsumers().get(i).getId(),
                    input.getInitialData().getConsumers().get(i).getInitialBudget(),
                    input.getInitialData().getConsumers().get(i).getMonthlyIncome(),
                    0,  0,  0, null);
            consumerOuts.add((ConsumerOut) consumerFactory);
        }

        //preiau toate datele pentru distribuitori din input si le pun in
        //arrayul distributor
        for (int i = 0; i < input.getInitialData().getDistributors().size(); i++) {
            DistributorOut distributor = new DistributorOut();
            //utilizez factory pentru a construi obiecte
            Common distributorFactory = FactoryOutClasses.createEntity(distributor,
                    input.getInitialData().getDistributors().get(i).getId(),
                    input.getInitialData().getDistributors().get(i).getInitialBudget(), 0,
                    input.getInitialData().getDistributors().get(i).getContractLength(),
                    input.getInitialData().getDistributors().get(i).getInitialInfrastructureCost(),
                    input.getInitialData().getDistributors().get(i).getEnergyNeededKW(),
                    input.getInitialData().getDistributors().get(i).getProducerStrategy());
            distributorOuts.add((DistributorOut) distributorFactory);

        }

        for (int i = 0; i < input.getInitialData().getProducers().size(); i++) {
            ProducerOut producer = new
                    ProducerOut(input.getInitialData().getProducers().get(i).getId(),
                    input.getInitialData().getProducers().get(i).getMaxDistributors(),
                    input.getInitialData().getProducers().get(i).getPriceKW(),
                    input.getInitialData().getProducers().get(i).getEnergyType(),
                    input.getInitialData().getProducers().get(i).getEnergyPerDistributor()
                    );
            producerOuts.add(producer);
        }

        //prelucrez datele
        Action action =
                new Action(Integer.parseInt(input.getNumberOfTurns()),
                        consumerOuts, distributorOuts, producerOuts,
                        input.getMonthlyUpdates());
        action.algorithm();


        ArrayList<ConsumerResult> consumerArray = new ArrayList<>();
        ArrayList<DistributorResult> distributorArray = new ArrayList<>();
        ArrayList<ProducerResult> producerResultArray = new ArrayList<>();

        //preiau datele obtinute in urma prelucrarii consumatorilor
        for (int i = 0; i < action.getConsumers().size(); i++) {
            ConsumerResult consumer = new ConsumerResult(action.getConsumers().get(i).getId(),
                    action.getConsumers().get(i).isBankrupt(),
                    action.getConsumers().get(i).getFinalBudget());
            consumerArray.add(consumer);
        }


        //preiau datele obtinute in urma prelucrarii distribuitorilor
        for (int i = 0; i < action.getDistributors().size(); i++) {
            ArrayList<ConsumerDatesInContracts> consumerDatesInContracts =
                    new ArrayList<ConsumerDatesInContracts>();
            for (int j = 0; j < action.getDistributors().get(i).getConsumers().size(); j++) {
                ConsumerDatesInContracts consumer = new ConsumerDatesInContracts(
                        action.getDistributors().get(i).getConsumers().get(j).getId(),
                        action.getDistributors().get(i).getConsumers().get(j).getDebt(),
                        action.getDistributors().get(i).getConsumers().get(j)
                                .getContractMonthsRemained());
                consumerDatesInContracts.add(consumer);
            }

            DistributorResult distributor =
                    new DistributorResult(action.getDistributors().get(i).getId(),
                            action.getDistributors().get(i).getEnergyNeededKW(),
                            action.getDistributors().get(i).getContractCost(),
                            action.getDistributors().get(i).getFinalBudget(),
                            action.getDistributors().get(i).getStrategyType(),
                            action.getDistributors().get(i).isBankrupt(), consumerDatesInContracts);
            distributorArray.add(distributor);
        }

        //preiau datele obtinute in urma prelucrarii producatorilor
        for (int i = 0; i < action.getProducers().size(); i++) {
            ProducerResult producer = new ProducerResult(action.getProducers().get(i).getId(),
                    action.getProducers().get(i).getMaxDistributors(),
                    action.getProducers().get(i).getPriceKW(),
                    action.getProducers().get(i).getEnergyType(),
                    action.getProducers().get(i).getEnergyPerDistributor(),
                    action.getProducers().get(i).getMonthlyStats());
            producerResultArray.add(producer);
        }


        //construiesc output
        CreateOutput output = new
                CreateOutput(consumerArray, distributorArray, producerResultArray);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[1]), output);


    }




}
