/*
 * Copyright (C) 2016-2021 Álinson Santos Xavier <git@axavier.org>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.core.models.sqlite.records;

import org.isoron.uhabits.core.database.*;
import org.isoron.uhabits.core.models.*;

/**
 * The SQLite database record corresponding to a {@link Entry}.
 */
@Table(name = "Repetitions")
public class EntryRecord
{
    public HabitRecord habit;

    @Column(name = "habit")
    public Long habitId;

    @Column
    public Long timestamp;

    @Column
    public Integer value;

    @Column
    public Long id;

    public void copyFrom(Entry entry)
    {
        timestamp = entry.getTimestamp().getUnixTime();
        value = entry.getValue();
    }

    public Entry toEntry()
    {
        return new Entry(new Timestamp(timestamp), value);
    }
}
