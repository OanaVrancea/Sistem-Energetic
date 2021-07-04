package action;

import outclasses.ConsumerOut;
import outclasses.DistributorOut;
import inputloader.MonthlyUpdates;
import outclasses.MonthlyStats;
import outclasses.ProducerOut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Action {

    private int numberOfTurns;
    private List<ConsumerOut> consumersList = new ArrayList<ConsumerOut>();
    private List<DistributorOut> distributorsList = new ArrayList<DistributorOut>();
    private List<ProducerOut> producersList = new ArrayList<ProducerOut>();
    private List<MonthlyUpdates> monthlyUpdatesList = new ArrayList<MonthlyUpdates>();

    public Action(final int numberOfTurns, final List<ConsumerOut> consumers,
                  final List<DistributorOut> distributors,
                  final List<ProducerOut> producers,
                  final List<MonthlyUpdates> monthlyUpdates) {
        this.numberOfTurns = numberOfTurns;
        this.consumersList = consumers;
        this.distributorsList = distributors;
        this.producersList = producers;
        this.monthlyUpdatesList = monthlyUpdates;
    }

    /***
     * functie care imi intoarce distribuitorul cu cea mai mica rata
     * @param distributors
     * @return
     */
    public DistributorOut getMinimDistributor(final List<DistributorOut> distributors) {
        int poz = 0;
        //parcurg toti distribuitorii si il aleg pe primul
        //care in este in faliment
        for (int i = 0; i < distributors.size(); i++) {
            if (!distributors.get(i).isBankrupt()) {
                poz = i;
                break;
            }
        }

        DistributorOut minimDistributor = distributors.get(poz);
        int minimDistributourIndex = poz;

        //aleg distribuitorul cu cea mai mica rata lunara
        //acesta trebuie sa nu fi dat faliment
        for (int i = 1; i < distributors.size(); i++) {
            if (minimDistributor.getDebt() > distributors.get(i).getDebt()
                    && !distributors.get(i).isBankrupt()
                    && distributors.get(i).getDebt() >= 0) {
                minimDistributor = distributors.get(i);
                minimDistributourIndex = i;
            }
        }
        return minimDistributor;
    }

    /***
     * functie care returneaza indicele distribuitorului cu cea mai mica rata
     * @param distributors
     * @return
     */
    public int getMinimDistributorIndex(final List<DistributorOut> distributors) {

        //parcurg toti distribuitorii si il aleg pe primul
        //care in este in faliment
        int poz = 0;
        for (int i = 0; i < distributors.size(); i++) {
            if (!distributors.get(i).isBankrupt()) {
                poz = i;
                break;
            }
        }

        DistributorOut minimDistributor = distributors.get(poz);
        int minimDistributourIndex = poz;

        //aleg distribuitorul cu cea mai mica rata lunara
        //acesta trebuie sa nu fi dat faliment
        for (int i = 1; i < distributors.size(); i++) {
            if (!distributors.get(i).isBankrupt()) {
                if (minimDistributor.getDebt() > distributors.get(i).getDebt()
                        && distributors.get(i).getDebt() >= 0) {
                    minimDistributor = distributors.get(i);
                    minimDistributourIndex = i;
                }
            }
        }
        return minimDistributourIndex;
    }

    /***
     * calculez bugetul unui consumator care a avut datorie
     * @param consumer
     * @param distributor
     */
    public void calculateCurrentBudgetWithDebt(final ConsumerOut consumer,
                                               final DistributorOut distributor) {
        //suma pe care o are consumatorul in prezent dupa ce
        //nu a mai platit doua rate
        int newSum = consumer.getFinalBudget() + consumer.getMonthlyIncome()
                + consumer.getMonthlyIncome();
        // int newSum = consumer.getFinalBudget() + consumer.getMonthlyIncome();
        //          + consumer.getMonthlyIncome();
        //datoria totala, compusa din cea pe care trebuia sa o plateasca
        // plus dobanda, si cea actuala
        int totalDebt = consumer.getDebtForUnpayedMonth() + consumer.getDebt();
        // int totalDebt = consumer.getDebt();
        int dif = newSum - totalDebt;
        consumer.getDistributorOut().setFinalBudget(dif);
        //daca nu isi poate achita datoria
        if (newSum <= totalDebt) {
            //acesta este considerat in faliment
            consumer.setBankrupt(true);
            consumer.setDebtForUnpayedMonth(0);
            consumer.setFinalBudget(newSum - consumer.getMonthlyIncome());
        } else {
            //isi achita datoria
            consumer.setDebtForUnpayedMonth(0);
            //nu mai are datorie fata de niciun distribuitor
            consumer.setDelay(0);
        }

    }

    /***
     * functie care calculeaza bugetul unui consumator
     * care are o datorie fata de distribuitorul anterior,
     * dar si-a reinnoit contractul cu altul
     * @param consumer
     * @param distributor
     */
    public void calculateCurrentBudgetWithDebtAtNewDistrubutor(final ConsumerOut consumer,
                                                               final DistributorOut distributor) {
        //suma pe care o are consumatorul in prezent dupa ce
        //nu a mai platit doua rate
        int newSum = consumer.getFinalBudget() + consumer.getMonthlyIncome()
                + consumer.getMonthlyIncome();
        // int newSum = consumer.getFinalBudget() + consumer.getMonthlyIncome();
        //          + consumer.getMonthlyIncome();
        //datoria totala, compusa din cea pe care trebuia sa o plateasca
        // plus dobanda, si cea actuala
        int totalDebt = consumer.getDebtForUnpayedMonth();
        // int totalDebt = consumer.getDebt();
        int dif = newSum - totalDebt;
        consumer.getDistributorOut().setFinalBudget(dif);
        //daca nu isi poate achita datoria
        if (newSum <= totalDebt) {
            //acesta este considerat in faliment
            consumer.setBankrupt(true);
            consumer.setDebtForUnpayedMonth(0);
            consumer.setFinalBudget(newSum);
        } else {
            //isi achita datoria
            consumer.setDebtForUnpayedMonth(consumer.getDebt());
            //nu mai are datorie fata de niciun distribuitor
            consumer.setDelay(1);
        }

    }

    /***
     * calculeaza bugetul unui consumator care inca nu a avut nicio datorie
     * @param consumer
     * @param distributor
     */
    public void calculateCurrentBudget(final ConsumerOut consumer,
                                       final DistributorOut distributor) {
        int newSum = 0;
        //noul buget pe care il are consumatorul
        newSum = consumer.getFinalBudget() - consumer.getDebt() + consumer.getMonthlyIncome();
        if (newSum >= 0) {
            consumer.setFinalBudget(newSum);
        } else if (newSum + consumer.getMonthlyIncome() < consumer.getDebt()) {
            //daca acesta nu isi poate achita urmatoarea rata
            if (consumer.getDelay() == 0) {
                //retin ca nu si-a achitat o rata
                consumer.setDelay(1);
                //calculez datoria pe care o are fata de un distribuitor
                int newDebt = (int) Math.round(Math.floor(1.2 * consumer.getDebt()));
                consumer.setDebtForUnpayedMonth(newDebt);
                // System.out.println(consumer.getFinalBudget() + consumer.getMonthlyIncome());
                consumer.setFinalBudget(consumer.getFinalBudget() + consumer.getMonthlyIncome());
            }
        }
    }


    /***
     * functie care calculeaza lunile ramase din contract
     * @param consumerOuts
     */
    public void passedMonth(final List<ConsumerOut> consumerOuts) {
        int i;
        for (i = 0; i < consumerOuts.size(); i++) {
            int remainedMonths = consumerOuts.get(i).getContractMonthsRemained() - 1;
            if (remainedMonths >= 0) {
                //la trecerea unei runda(luni) scad din contractele
                //fiecarui consumator 1
                consumerOuts.get(i).setContractMonthsRemained(remainedMonths);
            }
        }
    }


    /***
     * functie care calculeaza rata fara consumatori
     * @param distributor
     * @return
     */
    public int calculateRateWithoutConsumers(final DistributorOut distributor) {
        int infrastructureCost = distributor.getInitialInfrastructureCost();
        int productionCost = distributor.getProductionCost();
        int profit = (int) Math.round(Math.floor(0.2 * productionCost));
        int rate = infrastructureCost + productionCost + profit;
        return rate;
    }

    /***
     * functie care calculeaza rata cu consumatori
     * @param distributor
     * @param consumersNumber
     * @return
     */
    public int calculateRateWithConsumers(final DistributorOut distributor,
                                          final int consumersNumber) {
        int infrastructureCost = distributor.getInitialInfrastructureCost();
        int productionCost = distributor.getProductionCost();
        int profit = (int) Math.round(Math.floor(0.2 * productionCost));
        int rate = (int) Math
                .round(Math.floor(infrastructureCost / consumersNumber) + productionCost + profit);
        return rate;
    }


    /***
     * calculeaza bugetul unui distribuitor fara consumatori
     * @param distributor
     * @return
     */
    public int calculateBudgetNoConsumers(final DistributorOut distributor) {

        int budget = distributor.getFinalBudget();
        //daca acesta nu a falimentat inca
        if (distributor.getFinalBudget() >= 0) {
            budget = 0;
            budget = distributor.getFinalBudget() - distributor.getInitialInfrastructureCost();
            //pentru toti clientii care au falimentat sau au plecat
            // scad costul de productie
            if (distributor.getLostClient() >= 1) {
                int aux = distributor.getLostClient();
                while (aux > 0) {
                    budget = budget - distributor.getProductionCost();
                    aux--;
                }
                distributor.setLostClient(0);
            }
        }
        return budget;
    }


    /***
     * calculeaza bugetul unui distribuitor cu consumatori
     * @param distributor
     * @param consumers
     * @return
     */
    public int calculateBudgetWithConsumers(final DistributorOut distributor,
                                            final List<ConsumerOut> consumers) {
        int budget = distributor.getFinalBudget();
        int i;
        //daca acesta nu a falimentat inca
        if (distributor.getFinalBudget() >= 0) {
            budget = distributor.getFinalBudget() - distributor.getInitialInfrastructureCost();
            int spendings = distributor.getInitialInfrastructureCost();
            for (i = 0; i < consumers.size(); i++) {
                budget = budget + consumers.get(i).getDebt()
                        - distributor.getProductionCost();
                spendings = spendings + distributor.getProductionCost();
            }
            //daca consumatorii nu isi pot achita datoria se scade
            //din bugetul final rata pe care acestia ar fi
            //trebuit sa o achite
            for (i = 0; i < consumers.size(); i++) {
                if (consumers.get(i).getDelay() == 1) {
                    budget = budget - consumers.get(i).getDebt();
                }
            }


          /*  for (i = 0; i < distributor.getConsumers().size(); i++) {
                if (distributor.getConsumers().get(i).getDelay() == 1) {
                    System.out.println("da");
                    budget = budget - distributor.getConsumers().get(i).getDebt();
                    spendings = spendings + distributor.getConsumers().get(i).getDebt();
                }
            }*/

            //pentru toti clientii care au falimentat sau au plecat
            // scad costul de productie
            if (distributor.getLostClient() >= 1) {
                int aux = distributor.getLostClient();
                while (aux > 0) {
                    budget = budget - distributor.getProductionCost();
                    aux--;
                    spendings = spendings + distributor.getProductionCost();
                }
                distributor.setLostClient(0);
            }
        }


        return budget;
    }

    /***
     * functie care sorteaza toti producatorii
     * pentru un anumit distribuitor in functie de strategie
     * @param distributors
     * @param producers
     */
    public void sortProducersForDistributors(final DistributorOut distributors,
                                             final List<ProducerOut> producers) {


        List<ProducerOut> aux = new ArrayList<>();
        List<ProducerOut> producerOuts = new ArrayList<>();

        //adaug toti producatorii in ordinea lor initiala in lista aux
        for (int i = 0; i < producers.size(); i++) {
            aux.add(producers.get(i));
        }

        //aplic functia de sortare care imi va sorta toti producatorii
        //in functie de strategia de alegere a distribuitorului
        producerOuts = distributors.sortedProducers(aux);

        //se sterg toate elementele din lista anterioara de sortata de producatori pe care
        // o avea distribuitorul
        distributors.getAllProducersSortedForSpecificDistributor()
                .removeAll(distributors.getAllProducersSortedForSpecificDistributor());

        //se adauga noii producatori in lista distribuiorului
        //in ordinea sortarii
        for (ProducerOut p : producerOuts) {
            distributors.getAllProducersSortedForSpecificDistributor().add(p);
        }

        distributors.setAllProducersSortedForSpecificDistributor(
                distributors.getAllProducersSortedForSpecificDistributor());


    }

    /***
     * functie care alege producatorii de care are nevoie
     * un distribuitor in luna respectiva
     * @param distributors
     */
    public void chooseProducersForDistributors(final DistributorOut distributors) {

        int sum = 0;
        List<ProducerOut> producerOutList = new ArrayList<>();

        //pentru un distribuitor parcurg lista cu distribuitori sortati specifica acestuia
        for (int j = 0; j < distributors.getAllProducersSortedForSpecificDistributor().size();
             j++) {
            //daca producatorul curent nu si-a atins capacitatea maxima de distribuitori
            if (distributors.getAllProducersSortedForSpecificDistributor().get(j)
                    .getDistributorOfProducer().size()
                    < distributors.getAllProducersSortedForSpecificDistributor().get(j)
                    .getMaxDistributors()) {
                // adunam la sum cantitatea de energie pe care o ofera
                sum = sum + distributors.getAllProducersSortedForSpecificDistributor().get(j)
                        .getEnergyPerDistributor();
                //il adaugam in lista de producatori a distribuitorului
                producerOutList
                        .add(distributors.getAllProducersSortedForSpecificDistributor().get(j));
                //adaugam si distribuitorul in lista producatorului
                distributors.getAllProducersSortedForSpecificDistributor().get(j)
                        .getDistributorOfProducer().add(distributors);
                distributors.getAllProducersSortedForSpecificDistributor().get(j)
                        .setDistributorOfProducer(
                                distributors.getAllProducersSortedForSpecificDistributor().get(j)
                                        .getDistributorOfProducer());
                //daca se acopera cantitatea maxima de energie
                // nu se mai cauta alti producatori
                if (sum >= distributors.getEnergyNeededKW()) {
                    break;
                }
            }
        }
        //setam lista de producatori de la care distribuitorul ia energie
        distributors.setProducers(producerOutList);


    }

    /***
     * functie care calculeaza costul de productie
     * @param distributor
     */
    public void calculateProductionCost(final DistributorOut distributor) {
        int i;
        float sum = 0;
        for (i = 0; i < distributor.getProducers().size(); i++) {
            sum = sum + distributor.getProducers().get(i).getEnergyPerDistributor()
                    * distributor.getProducers().get(i).getPriceKW();
        }
        int productionCost = (int) Math.round(Math.floor(sum / 10));
        distributor.setProductionCost(productionCost);
    }

    /***
     * calculeaza datele pentru runda initiala
     */
    public void setFirstRoundData() {

        //pentru toti distribuitorii
        //sortez producatorii in functie de strategie
        //si aleg cati producatori imi trebuie
        for (int m = 0; m < this.getDistributors().size(); m++) {
            sortProducersForDistributors(this.getDistributors().get(m), this.getProducers());
            chooseProducersForDistributors(this.getDistributors().get(m));
        }

        // calculez costul de productie
        for (int i = 0; i < this.getDistributors().size(); i++) {
            calculateProductionCost(this.getDistributors().get(i));
        }

        //calculez ratele de inceput pentru toti consumatorii
        for (int i = 0; i < this.getDistributors().size(); i++) {
            //in prima runda niciunul nu are consumatori
            int rate = calculateRateWithoutConsumers(this.getDistributors().get(i));
            //setez rata la valoarea calculata
            this.getDistributors().get(i).setDebt(rate);
            this.getDistributors().get(i).setContractCost(rate);
        }

        DistributorOut minimDistributour = new DistributorOut();
        int minimDistributourIndex;

        //intorc cel mai mic distribuitor si pozitia sa
        minimDistributour = getMinimDistributor(this.getDistributors());
        minimDistributourIndex = getMinimDistributorIndex(this.getDistributors());

        //la inceput adaug toti consumatorii existenti in
        //lista de contracte a distribuitorului cu rata cea mai mica
        for (int i = 0; i < this.getConsumers().size(); i++) {
            this.getConsumers().get(i).setDebt(minimDistributour.getDebt());
            //setez pentru acestia distribuitorul cu care au contract
            this.getConsumers().get(i).setDistributorOut(minimDistributour);

            // daca nu isi pot achita prima rata setez campul Delay la 1
            //si salvez rata pe care nu au putut sa o achite
            if (this.getConsumers().get(i).getInitialBudget()
                    + this.getConsumers().get(i).getMonthlyIncome()
                    < this.getDistributors().get(minimDistributourIndex).getDebt()) {
                this.getConsumers().get(i).setDelay(1);
                this.getConsumers().get(i).setDebtForUnpayedMonth(
                        this.getDistributors().get(minimDistributourIndex).getDebt());
            }
            //pentru acest distribuitor adaug consumatorii in lista de contracte
            this.getDistributors().get(minimDistributourIndex).getConsumers().add(
                    this.getDistributors().get(minimDistributourIndex).getConsumers().size(),
                    this.getConsumers().get(i));
            //setez numarul de contracte
            this.getDistributors().get(minimDistributourIndex).setConsumersNumber(
                    this.getDistributors().get(minimDistributourIndex).getConsumers().size());
            //setez si durata contractului
            this.getConsumers().get(i).setContractMonthsRemained(
                    this.getDistributors().get(minimDistributourIndex).getContractLength());
        }

        //calculez dupa prima runda bugetele pentru toti distribuitorii
        for (int j = 0; j < this.getDistributors().size(); j++) {
            if (this.getDistributors().get(j).getConsumersNumber() == 0) {
                int budget = calculateBudgetNoConsumers(this.getDistributors().get(j));
                this.getDistributors().get(j).setFinalBudget(budget);
                //daca bugetul este negativ salvez distribuitorul ca fiind
                //falimentat
                if (budget < 0) {
                    this.getDistributors().get(j).setBankrupt(true);
                }
            } else {
                int budget = calculateBudgetWithConsumers(this.getDistributors().get(j),
                        this.getDistributors().get(j).getConsumers());
                this.getDistributors().get(j).setFinalBudget(budget);
                //daca bugetul este negativ salvez distribuitorul ca fiind
                //falimentat
                if (budget < 0) {
                    this.getDistributors().get(j).setBankrupt(true);
                }
            }
        }

        //scad 1 din numarul de luni al contractului
        passedMonth(this.getConsumers());

    }

    /***
     * verifica daca exista consumatori noi intr-o anumita luna
     * @param monthlyUpdates
     * @param distributors
     */
    public void checkUpdatesNewConsumers(final MonthlyUpdates monthlyUpdates,
                                         final List<DistributorOut> distributors) {
        int i;
        //daca exista consumatori noi intr o anumita runda
        if (monthlyUpdates.getNewConsumers() != null) {
            for (i = 0; i < monthlyUpdates.getNewConsumers().size(); i++) {
                //iau datele, contruiesc un nou consumator
                //si il adaug in lista de consumatori existenta
                int id = monthlyUpdates.getNewConsumers().get(i).getId();
                int initialBudget = monthlyUpdates.getNewConsumers().get(i).getInitialBudget();
                int monthlyIncome = monthlyUpdates.getNewConsumers().get(i).getMonthlyIncome();
                ConsumerOut newConsumer = new ConsumerOut(id, initialBudget, monthlyIncome);
                //ii setez lunile din contract cu -1
                //pentru a il diferentia de ceilalti in celelalte procese
                newConsumer.setContractMonthsRemained(-1);
                this.getConsumers().add(this.getConsumers().size(), newConsumer);
            }
        }
    }

    /***
     * functie care verifica daca au existat schimbari pentru
     * distribuitori intr-o anumita luna
     * @param monthlyUpdates
     */
    public void checkUpdatesDistributorChanges(final MonthlyUpdates monthlyUpdates) {
        int i;
        //daca exista schimbari pentru distribuitori
        if (monthlyUpdates.getDistributorChanges() != null) {
            for (i = 0; i < monthlyUpdates.getDistributorChanges().size(); i++) {
                for (int j = 0; j < this.getDistributors().size(); j++) {
                    if (monthlyUpdates.getDistributorChanges().get(i).getId()
                            == this.getDistributors().get(j).getId()) {
                        //actualizez costul pentru infrastructura
                        int newInfrastructureCost = monthlyUpdates.getDistributorChanges().get(i)
                                .getInfrastructureCost();
                        this.getDistributors().get(j)
                                .setInitialInfrastructureCost(newInfrastructureCost);
                    }
                }
            }
        }
    }

    /***
     * functie care elimina un distribuitor din toti producatorii
     * in care se afla
     * @param distributor
     * @param producers
     */
    public void removeDistributorFromProducers(DistributorOut distributor,
                                               List<ProducerOut> producers) {


        //parcurg toti producatorii
        for (int i = 0; i < producers.size(); i++) {
            //daca contin un anumit distribuitor
            if (producers.get(i).getDistributorOfProducer().contains(distributor)) {
                //acesta este sters
                producers.get(i).getDistributorOfProducer().remove(distributor);
                producers.get(i)
                        .setDistributorOfProducer(producers.get(i).getDistributorOfProducer());
            }
        }

    }

    /***
     * functie care verifica daca au existat schimbari in randul producatorilor
     * intr-o anumita luna
     * @param monthlyUpdates
     */
    public void checkUpdatesProducerChanges(final MonthlyUpdates monthlyUpdates) {
        int i;
        //daca exista modificari in randul producatorilor
        if (monthlyUpdates.getProducerChanges() != null) {
            for (i = 0; i < monthlyUpdates.getProducerChanges().size(); i++) {
                for (int j = 0; j < this.getProducers().size(); j++) {
                    if (monthlyUpdates.getProducerChanges().get(i).getId()
                            == this.getProducers().get(j).getId()) {
                        //se seteaza noua valoare de energie acordata per distribuitor
                        int energyPerDistributor = monthlyUpdates.getProducerChanges().get(i)
                                .getEnergyPerDistributor();
                        this.getProducers().get(j).setEnergyPerDistributor(energyPerDistributor);

                        //toti distribuitorii corespunzatori producatorilor care sufera modificari
                        // trebuie sa isi sorteze iar lista de producatori
                        //si sa aleaga altii
                        //ii vor retine in lista must choose producer
                        ArrayList<DistributorOut> mustChooseProducer = new ArrayList<>();

                        //retin toti distribuitorii producatorilor care sufera modificari
                        //in lista
                        for (int k = 0;
                             k < this.getProducers().get(j).getDistributorOfProducer().size();
                             k++) {
                            if (!mustChooseProducer.contains(
                                    this.getProducers().get(j).getDistributorOfProducer().get(k))) {
                                mustChooseProducer
                                        .add(this.getProducers().get(j).getDistributorOfProducer()
                                                .get(k));
                            }
                        }

                        //ii elimin din toti producatorii in care se afla
                        for (int k = 0;
                             k < this.getProducers().get(j).getDistributorOfProducer().size();
                             k++) {
                            removeDistributorFromProducers(
                                    this.getProducers().get(j).getDistributorOfProducer().get(k),
                                    this.getProducers());
                        }


                        for (int k = 0; k < mustChooseProducer.size(); k++) {
                            for (int t = 0; t < this.getProducers().size(); t++) {
                                if (this.getProducers().get(t).getDistributorOfProducer()
                                        .contains(mustChooseProducer.get(k))) {
                                    this.getProducers().get(t).getDistributorOfProducer()
                                            .remove(mustChooseProducer.get(k));
                                    this.getProducers().get(t).setDistributorOfProducer(
                                            this.getProducers().get(t).getDistributorOfProducer());
                                }
                            }
                        }

                        //producatorii care sufera modificari isi golesc lista de producatori
                        for (int k = 0;
                             k < this.getProducers().get(j).getDistributorOfProducer().size();
                             k++) {
                            this.getProducers().get(j).getDistributorOfProducer().removeAll(
                                    this.getProducers().get(j).getDistributorOfProducer());
                        }


                        //se sorteaaza iar producatorii pentru fiecare distribuitor
                        //si se realeg cei mai potriviti
                        for (int m = 0; m < mustChooseProducer.size(); m++) {
                            sortProducersForDistributors(mustChooseProducer.get(m),
                                    this.getProducers());
                            chooseProducersForDistributors(mustChooseProducer.get(m));
                        }
                        //se recalculeaza costul de productie
                        for (int k = 0; k < mustChooseProducer.size(); k++) {
                            calculateProductionCost(mustChooseProducer.get(k));
                        }
                    }
                }
            }
        }
    }

    /***
     * alogritm care calculeaza datele pe parcursul lunilor
     */
    public void algorithm() {
        //modific datele pentru a obtine rezultatele dupa prima runda
        setFirstRoundData();
        int i, j;
        int rate;
        for (i = 0; i < this.getNumberOfTurns(); i++) {

            List<ConsumerOut> consumerOuts = new ArrayList<>();

            //se verifica daca se adauga consumatori noi
            checkUpdatesNewConsumers(this.getMonthlyUpdates().get(i), this.getDistributors());
            //se verifica daca distribuitorii sufera modificari
            checkUpdatesDistributorChanges(this.getMonthlyUpdates().get(i));


            //calculez noile rate pentru distribuitori
            for (j = 0; j < this.getDistributors().size(); j++) {
                if (this.getDistributors().get(j).getConsumers().size() == 0) {
                    rate = calculateRateWithoutConsumers(this.getDistributors().get(j));
                    this.getDistributors().get(j).setDebt(rate);
                    this.getDistributors().get(j).setContractCost(rate);
                } else {
                    rate = calculateRateWithConsumers(this.getDistributors().get(j),
                            this.getDistributors().get(j).getConsumers().size());
                    this.getDistributors().get(j).setDebt(rate);
                    this.getDistributors().get(j).setContractCost(rate);
                }
            }


            //verific daca exista noi consumatori care trebuie adaugati

            //intorc indicele celui mai mic consumator
            int minim = getMinimDistributorIndex(this.getDistributors());

            //elimin din distribuitori consumatorii care au falimentat
            for (int n = 0; n < this.getDistributors().size(); n++) {
                this.getDistributors().get(n).getConsumers()
                        .removeIf(ConsumerOut::isBankrupt);
                this.getDistributors().get(n)
                        .setConsumersNumber(this.getDistributors().get(n).getConsumers().size());
            }


            //elimin din lista de contracte pentru toti
            //ditribuitorii consumatorii carora le-a expirat contractul
            for (int n = 0; n < this.getDistributors().size(); n++) {
                Iterator<ConsumerOut> it = this.getDistributors().get(n).getConsumers().iterator();
                while (it.hasNext()) {
                    ConsumerOut consumer = it.next();
                    if (consumer.getContractMonthsRemained() == 0) {
                        it.remove();

                    }
                }
                this.getDistributors().get(n)
                        .setConsumersNumber(this.getDistributors().get(n).getConsumers().size());
            }

            //parcurg toti distribuitorii
            for (int n = 0; n < this.getDistributors().size(); n++) {
                //daca intalnesc unul falit
                if (this.getDistributors().get(n).getFinalBudget() < 0) {
                    for (int l = 0; l < this.getDistributors().get(n).getConsumers().size(); l++) {
                        //setez numrul de luni la 0 din contractele ramase
                        this.getDistributors().get(n).getConsumers().get(l)
                                .setContractMonthsRemained(0);
                        //daca erat datori, acestia scapa de datorie
                        this.getDistributors().get(n).getConsumers().get(l)
                                .setDebtForUnpayedMonth(0);
                        this.getDistributors().get(n).getConsumers().get(l).setDelay(0);
                    }
                    //elimin toate contractele din lista distribuitorilor
                    this.getDistributors().get(n).getConsumers()
                            .removeAll(this.getDistributors().get(n).getConsumers());
                    this.getDistributors().get(n).setConsumersNumber(0);
                }
            }


            //aleg noi contracte pentru consumatorii
            //care au campul contractMonthsRemained = 0
            //(le-a expirat contractul vechi sau le-a
            //falimentat distrtribuitorul) si nu sunt faliti


            for (j = 0; j < this.getConsumers().size(); j++) {
                if (this.getConsumers().get(j).getContractMonthsRemained() == 0
                        && !this.getConsumers().get(j).isBankrupt()) {
                    //daca aceste era dator unui distribuitor
                    //si il alege pe altul este scutit de datorie
                    if ((this.getConsumers().get(j).getDistributorOut().getId()
                            != this.getDistributors().get(minim).getId())
                            && this.getConsumers().get(j).getDelay() == 1) {
                        this.getConsumers().get(j).setDelay(2);
                        //    this.getConsumers().get(j).setDebtForUnpayedMonth(0);
                    }

                    //setez noul distribuitor pentru consumatori
                    this.getConsumers().get(j).setDistributorOut(this.getDistributors().get(minim));

                    //adaug toti consumatorii noi in comsumerOuts pentru
                    //a le modifica un camp mai tarziu
                    consumerOuts.add(consumerOuts.size(), this.getConsumers().get(j));

                    // in lista distribuitorului minim adaug contractele noi
                    this.getDistributors().get(minim).getConsumers()
                            .add(this.getDistributors().get(minim).getConsumersNumber(),
                                    this.getConsumers().get(j));
                    this.getDistributors().get(minim).setConsumersNumber(
                            this.getDistributors().get(minim).getConsumers().size());
                }
            }

            //aleg contractul pentru consumatorii noi adaugati
            for (j = 0; j < this.getConsumers().size(); j++) {
                if (this.getConsumers().get(j).getContractMonthsRemained() == -1
                        && !this.getConsumers().get(j).isBankrupt()) {
                    //le setez valoarea ratei alese
                    this.getConsumers().get(j).setDebt(this.getDistributors().get(minim).getDebt());
                    //verific daca intra in datorie din prima runda in care sunt adaugati
                    if (this.getConsumers().get(j).getMonthlyIncome()
                            + this.getConsumers().get(j).getInitialBudget()
                            < this.getConsumers().get(j).getDebt()) {
                        this.getConsumers().get(j).setDelay(1);
                        this.getConsumers().get(j).setDebtForUnpayedMonth(
                                this.getDistributors().get(minim).getDebt());
                    }
                    //le setez distribuitorul cu care au contract
                    this.getConsumers().get(j).setDistributorOut(this.getDistributors().get(minim));

                    consumerOuts.add(consumerOuts.size(), this.getConsumers().get(j));

                    //adaug in lista distribuitorului noul contract
                    this.getDistributors().get(minim).getConsumers()
                            .add(this.getDistributors().get(minim).getConsumersNumber(),
                                    this.getConsumers().get(j));
                    this.getDistributors().get(minim).setConsumersNumber(
                            this.getDistributors().get(minim).getConsumers().size());
                }
            }

            // calculez bugetul pentru consumatori
            for (j = 0; j < this.getConsumers().size(); j++) {
                if (this.getConsumers().get(j).getDelay() == 0
                        && this.getConsumers().get(j).getContractMonthsRemained() >= 0) {
                    calculateCurrentBudget(this.getConsumers().get(j),
                            this.getConsumers().get(j).getDistributorOut());
                } else if (!this.getConsumers().get(j).isBankrupt()
                        && this.getConsumers().get(j).getContractMonthsRemained() >= 0
                        && this.getConsumers().get(j).getDelay() == 1) {
                    calculateCurrentBudgetWithDebt(this.getConsumers().get(j),
                            this.getConsumers().get(j).getDistributorOut());
                } else if (!this.getConsumers().get(j).isBankrupt()
                        && this.getConsumers().get(j).getContractMonthsRemained() >= 0
                        && this.getConsumers().get(j).getDelay() == 2) {
                    calculateCurrentBudgetWithDebtAtNewDistrubutor(this.getConsumers().get(j),
                            this.getConsumers().get(j).getDistributorOut());
                }

            }

            // parcurg listele de contracte ale tuturor distribuitorilor
            for (int n = 0; n < this.getDistributors().size(); n++) {
                for (int m = 0; m < this.getDistributors().get(n).getConsumers().size(); m++) {
                    //daca un consumator este falit si mai avea luni in contract
                    if (this.getDistributors().get(n).getConsumers().get(m).isBankrupt()) {
                        if (this.getDistributors().get(n).getConsumers().get(m)
                                .getContractMonthsRemained() >= 0) {
                            //acesta este eliminat din lista de contracte
                            this.getDistributors().get(n).getConsumers()
                                    .remove(this.getDistributors().get(n).getConsumers().get(m));
                            this.getDistributors().get(n).setConsumersNumber(
                                    this.getDistributors().get(n).getConsumers().size());
                        }
                        //retin ca distribuitorul a pierdut un client care nu i-a achitat
                        //o suma
                        this.getDistributors().get(n)
                                .setLostClient(this.getDistributors().get(n).getLostClient() + 1);

                    }
                }
            }


            //setez noile rate pentru consumatori
            for (j = 0; j < this.getConsumers().size(); j++) {
                if (this.getConsumers().get(j).getContractMonthsRemained() == 0) {
                    this.getConsumers().get(j).setDebt(this.getDistributors().get(minim).getDebt());
                }
            }

            //calculez bugetul noului distribuitor
            for (j = 0; j < this.getDistributors().size(); j++) {
                if (this.getDistributors().get(j).getConsumersNumber() == 0) {
                    int budget = calculateBudgetNoConsumers(this.getDistributors().get(j));
                    this.getDistributors().get(j).setFinalBudget(budget);
                    if (budget < 0) {
                        this.getDistributors().get(j).setBankrupt(true);
                    }
                } else {
                    int budget = calculateBudgetWithConsumers(this.getDistributors().get(j),
                            this.getDistributors().get(j).getConsumers());
                    this.getDistributors().get(j).setFinalBudget(budget);
                    if (budget < 0) {
                        this.getDistributors().get(j).setBankrupt(true);
                    }
                }
            }


            //setez noua lungime a contractului pentru toti consumatorii
            //care si-au ales contract luna aceasta
            for (j = 0; j < consumerOuts.size(); j++) {
                consumerOuts.get(j).setContractMonthsRemained(
                        consumerOuts.get(j).getDistributorOut().getContractLength());
            }

            //verific daca producatorii sufera modificari
            checkUpdatesProducerChanges(this.getMonthlyUpdates().get(i));

            //tin evidenta pentru ce distribuitori a avut fiecare producator in fiecare luna
            for (j = 0; j < this.getProducers().size(); j++) {
                int month = i + 1;
                List<Integer> ids = new ArrayList<>();
                for (int k = 0; k < this.getProducers().get(j).getDistributorOfProducer().size();
                     k++) {
                    ids.add(this.getProducers().get(j).getDistributorOfProducer().get(k).getId());
                }
                MonthlyStats monthlyStats = new MonthlyStats(month, ids);
                this.getProducers().get(j).getMonthlyStats().add(monthlyStats);
            }


            //scad din lungimea contractelor 1
            passedMonth(this.getConsumers());



        }


        //calculez bugetele finale
        for (j = 0; j < this.getConsumers().size(); j++) {
            if (this.getConsumers().get(j).getDelay() == 0) {
                calculateCurrentBudget(this.getConsumers().get(j),
                        this.getConsumers().get(j).getDistributorOut());
            } else {
                calculateCurrentBudgetWithDebt(this.getConsumers().get(j),
                        this.getConsumers().get(j).getDistributorOut());
            }
        }

        for (j = 0; j < this.getDistributors().size(); j++) {
            for (int k = 0; k < this.getDistributors().get(j).getConsumers().size(); k++) {
                if (this.getDistributors().get(j).getConsumers().get(k).getDelay() == 1) {
                    int sum = this.getDistributors().get(j).getFinalBudget()
                            - this.getDistributors().get(j).getConsumers().get(k).getDebt();
                    this.getDistributors().get(j).setFinalBudget(sum);
                }
            }
        }


    }

    /***
     * intoarce numar de luni
     * @return
     */
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    /***
     * seteaza numar luni
     * @param numberOfTurns
     */
    public void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    /***
     * intoarce lista consumatori
     * @return
     */
    public List<ConsumerOut> getConsumers() {
        return consumersList;
    }

    /***
     * seteaza lista consumatori
     * @param consumers
     */
    public void setConsumers(final List<ConsumerOut> consumers) {
        this.consumersList = consumers;
    }

    /***
     * intoarce lista distribuitori
     * @return
     */
    public List<DistributorOut> getDistributors() {
        return distributorsList;
    }

    /***
     * seteaza lista distribuitori
     * @param distributors
     */
    public void setDistributors(final List<DistributorOut> distributors) {
        this.distributorsList = distributors;
    }

    /***
     * intoarce schimbarile ce se produc pe parcursul lunilor
     * @return
     */
    public List<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdatesList;
    }

    /***
     * seteaza schimbarile ce se produc pe parcursul lunilor
     * @param monthlyUpdates
     */
    public void setMonthlyUpdates(final List<MonthlyUpdates> monthlyUpdates) {
        this.monthlyUpdatesList = monthlyUpdates;
    }

    /***
     * intoarce lista de producatori
     * @return
     */
    public List<ProducerOut> getProducers() {
        return producersList;
    }

    /***
     * seteaza lista de producatori
     * @param producers
     */
    public void setProducers(List<ProducerOut> producers) {
        this.producersList = producers;
    }

    /***
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Action{"
                + "numberOfTurns=" + numberOfTurns
                + ", consumers=" + consumersList
                + ", distributors=" + distributorsList
                + ", producers=" + producersList
                + ", monthlyUpdates=" + monthlyUpdatesList
                + '}';
    }
}
