package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> database = new HashMap();
    private long idCounter = 1;

    @Override
    public TimeEntry create(TimeEntry any) {
        any.setId(idCounter++);
        database.put(any.getId(), any);
        return any;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return database.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> list = new ArrayList<>(database.size());
        database.entrySet()
                .iterator()
                .forEachRemaining(
                        longTimeEntryEntry -> list.add(longTimeEntryEntry.getValue()
                        ));
        return list;

    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        TimeEntry timeEntryToUpdate =  database.get(eq);
        if(timeEntryToUpdate == null)
            return null;
        timeEntryToUpdate.setHours(any.getHours());
        timeEntryToUpdate.setDate(any.getDate());
        timeEntryToUpdate.setProjectId(any.getProjectId());
        timeEntryToUpdate.setUserId(any.getUserId());
        return timeEntryToUpdate;
    }


    @Override
    public void delete(long timeEntryId) {
        database.remove(timeEntryId);
    }

}
