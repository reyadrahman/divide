/*
 * Copyright (C) 2014 Divide.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.divide.client.auth;

import io.divide.client.auth.credentials.LocalCredentials;

import java.util.List;

public interface AccountStorage {

    public void addAcccount(LocalCredentials credentials);
    public void removeAccount(String accountName);
    public LocalCredentials getAccount(String accountName);
    public boolean isAuthenticated(String accountName);
    public void setAuthToken(String accountName, String token);
    public void setRecoveryToken(String accountName, String token);
    public List<LocalCredentials> getAccounts();
    public boolean exists(String name);

}
