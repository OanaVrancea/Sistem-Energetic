package outclasses;


import java.util.List;

public interface Strategy {
    /***
     * functie care sorteaza producatorii
     * pentru un distribuitor
     * in functie de strategie
     * @param producers
     * @return
     */
     List<ProducerOut> selectBestProducers(List<ProducerOut> producers);
}
