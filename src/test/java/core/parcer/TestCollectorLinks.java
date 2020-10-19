package core.parcer;

import core.collector.CollectKinoNewsSerialLinks;

import java.io.IOException;

public class TestCollectorLinks {
    public static void main(String[] args) throws IOException {
        CollectKinoNewsSerialLinks col = new CollectKinoNewsSerialLinks();
        col.collectString();
    }
}
