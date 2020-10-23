package core.collector;

import java.util.Set;

public interface ParseSerialLinks<From> {
    Set<String> getCurrentYearSerialLinks(From html);
}
