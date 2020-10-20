package core.collector;

import java.util.List;

public interface ParseSerialLinks<From> {
    List<String> getCurrentYearSerialLinks(From html);
}
