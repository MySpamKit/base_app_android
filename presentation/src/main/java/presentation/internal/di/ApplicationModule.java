/*
 * Copyright 2015 RefineriaWeb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package presentation.internal.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import data.internal.di.DataModule;
import presentation.foundation.BaseApp;

@Module(includes = DataModule.class) public class ApplicationModule {
    private final BaseApp baseApp;

    public ApplicationModule(BaseApp baseApp) {
        this.baseApp = baseApp;
    }

    @Provides @Singleton BaseApp provideApplication() {
        return baseApp;
    }

}
