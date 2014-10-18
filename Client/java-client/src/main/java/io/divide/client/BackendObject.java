/*
 * Copyright (C) 2014 Divide.io
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.divide.client;

import io.divide.shared.transitory.Credentials;
import io.divide.shared.transitory.FilePermissions;
import io.divide.shared.transitory.TransientObject;

public class BackendObject extends TransientObject {
    // FIXME stupidness of all this is just to have the
    // "this.setUserId()" in the constructor, all this nastyness is to hide
    // implementation info from TransientObject. Possible fix, have two implementations of same
    // class, data struct just needs to match, not implementation. Lose type safety...Is it really needed?
    private static final String USER_DATA = TransientObject.USER_DATA;
    private static final MetaKey OJBECT_TYPE_KEY = TransientObject.OBJECT_TYPE_KEY;
    private static final MetaKey USER_ID_KEY = TransientObject.OWNER_ID_KEY;

    public BackendObject() {
        FilePermissions fp = new FilePermissions();
        fp.setWritable(true, FilePermissions.Level.GROUP, FilePermissions.Level.WORLD);
        setFilePermissions(fp);
    }

    @Override
    protected final Credentials getLoggedInUser(){
        return BackendUser.getUser();
    }

    /**
     * Sets the user id for this object. Once set this can not be changed.
     * @param userId user id to be set.
     */
    @Override
    public void setOwnerId(Integer userId){
        super.setOwnerId(userId);
    }

}
