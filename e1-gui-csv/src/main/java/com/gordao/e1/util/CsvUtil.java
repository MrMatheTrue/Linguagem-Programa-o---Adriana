package com.gordao.e1.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class CsvUtil {
  private static final Path DATA_DIR = Paths.get("data");

  public static void append(String fileName, List<String> header, List<String> values) {
    try {
      if (!Files.exists(DATA_DIR)) {
        Files.createDirectories(DATA_DIR);
      }
      Path file = DATA_DIR.resolve(fileName);
      boolean newFile = !Files.exists(file);
      try (BufferedWriter w = Files.newBufferedWriter(file, StandardCharsets.UTF_8, 
              StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
        if (newFile) {
          w.write(serialize(header));
          w.newLine();
        }
        w.write(serialize(values));
        w.newLine();
      }
    } catch (IOException e) {
      throw new RuntimeException("Erro escrevendo CSV: " + e.getMessage(), e);
    }
  }

  private static String serialize(List<String> cols) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < cols.size(); i++) {
      if (i > 0) sb.append(',');
      sb.append(escape(cols.get(i)));
    }
    return sb.toString();
  }

  private static String escape(String v) {
    if (v == null) return "";
    boolean needQuote = v.contains(",") || v.contains("\"") || v.contains("\n") || v.contains("\r");
    String s = v.replace("\"", "\"\"");
    return needQuote ? "\"" + s + "\"" : s;
  }
}
