import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateTransactionIds {

  public static void main(String[] args) {
    List<String> transactionIds = List.of(
        "tx-1",
        "tx-2",
        "tx-3",
        "tx-2",
        "tx-4",
        "tx-1"
    );

    List<String> duplicates = findDuplicateTransactionIds(transactionIds);

    System.out.println(duplicates);
  }

  public static List<String> findDuplicateTransactionIds(List<String> transactionIds) {
    Set<String> seenTransactionId = new HashSet<>();
    List<String> duplicates = new ArrayList<>();

    transactionIds.forEach(transactionId -> {
      if (!seenTransactionId.contains(transactionId)) {
        seenTransactionId.add(transactionId);
      }else{
        duplicates.add(transactionId);
      }
    });
    return duplicates;
  }
}
