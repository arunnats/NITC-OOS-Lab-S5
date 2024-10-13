import java.util.List;
import java.util.stream.Stream;

public class Q3 {
    public static void main(String[] args) {
        List<String> stockBatch = List.of("AAPL", "GOOGL", "TSLA");
        StockProcessor stockProcessor = new StockProcessor("StockMarket", stockBatch);
        stockProcessor.loadData();
        stockProcessor.processData(); 
        stockProcessor.aggregateData("Daily");

        Stream<String> stockStream = Stream.of("AAPL", "AMZN", "TSLA");
        stockProcessor.processData(stockStream); 

        
        List<String> transactionBatch = List.of("TXN1", "TXN2", "TXN3");
        TransactionProcessor transactionProcessor = new TransactionProcessor("BankTransactions", transactionBatch);
        transactionProcessor.loadData();
        transactionProcessor.processData(); 
        transactionProcessor.aggregateData("User123", "High Risk");


        List<String> cryptoBatch = List.of("BTC", "ETH", "XRP");
        CryptoProcessor cryptoProcessor = new CryptoProcessor("CryptoExchange", cryptoBatch);
        cryptoProcessor.loadData();
        cryptoProcessor.processData(); 
        cryptoProcessor.aggregateData(); 
    }
}

abstract class DistributedDataProcessor {
    protected String dataSource;
    protected List<String> dataBatch;

    public DistributedDataProcessor(String dataSource, List<String> dataBatch) {
        this.dataSource = dataSource;
        this.dataBatch = dataBatch;
    }

    public void loadData() {
        System.out.println("Loading data from: " + dataSource);
        System.out.println("Data: " + dataBatch);
    }

    public abstract void processData();
    public abstract void processData(Stream<String> realTimeData); 
    public abstract void aggregateData();
}

class StockProcessor extends DistributedDataProcessor {

    public StockProcessor(String dataSource, List<String> dataBatch) {
        super(dataSource, dataBatch);
    }

    public void processData() {
        System.out.println("Processing historical stock data (batch mode)...");

        for (String stock : dataBatch) {
            System.out.println("Processing stock: " + stock);
        }
    }

    public void processData(Stream<String> realTimeData) {
        System.out.println("Processing real-time stock data (stream mode)...");

        realTimeData.parallel().forEach(stock -> {
            System.out.println("Processing stock stream: " + stock);
        });
    }

    public void aggregateData() {
        System.out.println("Aggregating stock data by time (e.g., hourly, daily)...");
    }

    public void aggregateData(String aggregationType) {
        System.out.println("Aggregating stock data: " + aggregationType + " based.");
    }
}

class TransactionProcessor extends DistributedDataProcessor {

    public TransactionProcessor(String dataSource, List<String> dataBatch) {
        super(dataSource, dataBatch);
    }

    public void processData() {
        System.out.println("Processing banking transactions (batch mode)...");

        for (String txn : dataBatch) {
            System.out.println("Processing transaction: " + txn);
        }
    }

    public void processData(Stream<String> realTimeData) {
        System.out.println("Real-time transaction processing is not implemented for this example.");
    }

    public void aggregateData() {
        System.out.println("Aggregating transactions by user.");
    }

    public void aggregateData(String userId, String riskProfile) {
        System.out.println("Aggregating transactions for user: " + userId + " with risk profile: " + riskProfile);
    }
}

class CryptoProcessor extends DistributedDataProcessor {

    public CryptoProcessor(String dataSource, List<String> dataBatch) {
        super(dataSource, dataBatch);
    }

    public void processData() {
        System.out.println("Processing cryptocurrency exchange rates (batch mode)...");

        for (String crypto : dataBatch) {
            System.out.println("Processing cryptocurrency: " + crypto);
        }
    }

    public void processData(Stream<String> realTimeData) {
        System.out.println("Real-time cryptocurrency processing is not implemented for this example.");
    }

    public void aggregateData() {
        System.out.println("Aggregating cryptocurrency data by currency.");
    }
}