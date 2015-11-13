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

package data.internal.di;

import javax.inject.Singleton;

import domain.sections.user_demo.UserDemoRepository;
import dagger.Module;
import dagger.Provides;
import data.net.RestApi;
import data.sections.user_demo.UserDemoDataRepository;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;


@Module public class DataModule {
    @Singleton @Provides RestApi provideRestApi() {
        return new Retrofit.Builder()
                .baseUrl(RestApi.URL_BASE)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RestApi.class);
    }


    @Provides @Singleton public UserDemoRepository provideUserDemoDataRepository(UserDemoDataRepository userDemoDataRepository) {
        return userDemoDataRepository;
    }
}
