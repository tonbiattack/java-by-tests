package examples.optional;
import org.junit.jupiter.api.Test;import java.util.Optional;import static org.junit.jupiter.api.Assertions.assertEquals;
class NicknamesTest {@Test void 値があるOptionalはその値を返す(){assertEquals("duke",Nicknames.displayName(Optional.of("duke")));}@Test void emptyのOptionalは既定値を返す(){assertEquals("anonymous",Nicknames.displayName(Optional.empty()));}}
