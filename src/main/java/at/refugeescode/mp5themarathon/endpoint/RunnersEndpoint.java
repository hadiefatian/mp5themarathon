package at.refugeescode.mp5themarathon.endpoint;

import at.refugeescode.mp5themarathon.model.Runner;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RunnersEndpoint {

    private List<Runner> runners = new ArrayList<>();

    @GetMapping("/runners")
    List<Runner> showAllRunners() {
        return runners;
    }

    @PostMapping("/runners")
    Runner post(@RequestBody Runner runner) {
        runners.add(runner);
        return runner;
    }


    @GetMapping("/winner")
    Runner showwinner() {
        Optional<Runner> first = runners.stream()
                .sorted((e1, e2) -> e1.getTime().compareTo(e2.getTime()))
                .findFirst();

        if (first.isPresent()) {
            return first.get();
        } else {
            return new Runner("no body");
        }
    }

}
