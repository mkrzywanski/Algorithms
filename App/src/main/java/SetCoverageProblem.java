import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

//Find minimal set of stations that covers whole Country using greedy algorithm approach
public class SetCoverageProblem {
    public static void main(String[] args) {
        Map<Integer, Set<String>> stationIdToState = new HashMap<>();

        stationIdToState.put(1, Sets.newHashSet("ID", "NV", "UT"));
        stationIdToState.put(2, Sets.newHashSet("WA", "ID", "MT"));
        stationIdToState.put(3, Sets.newHashSet("OR", "NV", "CA"));
        stationIdToState.put(4, Sets.newHashSet("NV", "UT"));
        stationIdToState.put(5, Sets.newHashSet("CA", "AZ"));

        Set<String> allStates = stationIdToState.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        Set<String> currentlyUncoveredStates = Sets.newHashSet(allStates);
        Set<Integer> currentStateIds = Sets.newHashSet();

        while (currentlyUncoveredStates.size() > 0) {
            int stationId = getStationIdWhichCoversMostStatesInUncoveredStates(stationIdToState, currentlyUncoveredStates);
            Set<String> states = stationIdToState.get(stationId);
            currentlyUncoveredStates.removeAll(states);
            currentStateIds.add(stationId);
            stationIdToState.remove(stationId);
        }

        currentStateIds.forEach(System.out::println);
    }

    private static int getStationIdWhichCoversMostStatesInUncoveredStates(Map<Integer, Set<String>> stationIdToState, Set<String> currentlyUncoveredStates) {
        int maxCoverage = 0;
        int stationIdWithMaxCoverage = 0;
        for (Map.Entry<Integer, Set<String>> entry : stationIdToState.entrySet()) {
            Set<String> stationStateCoverage = entry.getValue();
            Set<String> intersection = Sets.intersection(currentlyUncoveredStates, stationStateCoverage);
            if(intersection.size() > maxCoverage) {
                maxCoverage = intersection.size();
                stationIdWithMaxCoverage = entry.getKey();
            }
        }
        return stationIdWithMaxCoverage;
    }
}
