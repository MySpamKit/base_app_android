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

package presentation.sections.user_demo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import base.app.android.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import domain.sections.user_demo.entities.UserDemoEntity;
import presentation.utilities.recyclerview_adapter.ViewWrapper;

public class UserViewGroup extends FrameLayout implements ViewWrapper.Binder<UserDemoEntity> {
    @Bind(R.id.iv_avatar) protected ImageView iv_avatar;
    @Bind(R.id.tv_name) protected TextView tv_name;

    public UserViewGroup(Context context) {
        super(context);
        init();
    }

    public UserViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.user_view_group, this, true);
        ButterKnife.bind(this, view);
    }

    public void bind(UserDemoEntity user) {
        bind(user, 0);
    }

    @Override public void bind(UserDemoEntity user, int position) {
        Picasso.with(getContext()).load(user.getAvatarUrl())
                .centerCrop()
                .fit()
                .into(iv_avatar);
        tv_name.setText(user.getId() + ":" + user.getLogin());
    }
}
