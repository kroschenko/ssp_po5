package main4.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public record Page(List<Paragraph> paragraphs) {

    public Page(Paragraph... paragraph) {
        this(List.of(paragraph));
    }

    public String read() {
        return paragraphs.stream().map(Paragraph::text).collect(Collectors.joining("\n"));
    }

    public List<Integer> findAll(String regex) {
        int offset = 0;
        var starts = new ArrayList<Integer>();
        var pattern = Pattern.compile(regex);
        for (var paragraph : paragraphs) {
            var matcher = pattern.matcher(paragraph.text());
            while (matcher.find()) {
                starts.add(matcher.start() + offset);
            }
            offset += paragraph.text().length();
        }
        return starts;
    }
}
