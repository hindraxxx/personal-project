import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReconcileUnmatchedRecords {

  public static void main(String[] args) {
    List<TransactionRecord> bankRecords = List.of(
        new TransactionRecord("tx-1", 1000, Instant.parse("2026-05-15T10:00:00Z")),
        new TransactionRecord("tx-2", 2500, Instant.parse("2026-05-15T10:05:00Z"))
    );

    List<TransactionRecord> ledgerRecords = List.of(
        new TransactionRecord("tx-1", 1000, Instant.parse("2026-05-15T10:00:00Z")),
        new TransactionRecord("tx-2", 2400, Instant.parse("2026-05-15T10:05:00Z"))
    );

    Map<String, TransactionRecord> ledgerRecordMap = ledgerRecords.stream().collect(Collectors.toMap(TransactionRecord::id, transactionRecord ->  transactionRecord));
    List<MismatchedRecord> mismatchedRecords = bankRecords.stream().filter(
        bankRecord -> ledgerRecordMap.containsKey(bankRecord.id)
    ).filter(
        bankRecord -> ledgerRecordMap.get(bankRecord.id).amountCents != bankRecord.amountCents
    ).map(bankRecord -> new MismatchedRecord(bankRecord.id, bankRecord, ledgerRecordMap.get(bankRecord.id)))
        .toList()
    ;

    System.out.println(mismatchedRecords);
  }

  public record TransactionRecord(
      String id,
      int amountCents,
      Instant timestamp
  ) {
  }

  public record MismatchedRecord(
      String id,
      TransactionRecord bankRecord,
      TransactionRecord ledgerRecord
  ) {
  }

  public record ReconciliationResult(
      List<String> matchedIds,
      List<TransactionRecord> bankOnlyRecords,
      List<TransactionRecord> ledgerOnlyRecords,
      List<MismatchedRecord> mismatchedRecords
  ) {
  }
}
