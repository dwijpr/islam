package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat.MessagingStyle;
import android.support.v4.app.NotificationCompat.MessagingStyle.Message;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.p013f.C0275a;
import android.support.v7.appcompat.C0627R;
import android.support.v7.recyclerview.BuildConfig;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.util.List;

public class NotificationCompat extends android.support.v4.app.NotificationCompat {

    private static class Api24Extender extends BuilderExtender {
        private Api24Extender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.addStyleToBuilderApi24(notificationBuilderWithBuilderAccessor, builder);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    public static class Builder extends android.support.v4.app.NotificationCompat.Builder {
        public Builder(Context context) {
            super(context);
        }

        protected BuilderExtender getExtender() {
            return VERSION.SDK_INT >= 24 ? new Api24Extender() : VERSION.SDK_INT >= 21 ? new LollipopExtender() : VERSION.SDK_INT >= 16 ? new JellybeanExtender() : VERSION.SDK_INT >= 14 ? new IceCreamSandwichExtender() : super.getExtender();
        }

        protected CharSequence resolveText() {
            if (this.mStyle instanceof MessagingStyle) {
                MessagingStyle messagingStyle = (MessagingStyle) this.mStyle;
                Message access$000 = NotificationCompat.findLatestIncomingMessage(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (access$000 != null) {
                    return conversationTitle != null ? NotificationCompat.makeMessageLine(this, messagingStyle, access$000) : access$000.getText();
                }
            }
            return super.resolveText();
        }

        protected CharSequence resolveTitle() {
            if (this.mStyle instanceof MessagingStyle) {
                MessagingStyle messagingStyle = (MessagingStyle) this.mStyle;
                Message access$000 = NotificationCompat.findLatestIncomingMessage(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (!(conversationTitle == null && access$000 == null)) {
                    return conversationTitle != null ? conversationTitle : access$000.getSender();
                }
            }
            return super.resolveTitle();
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
    }

    public static class MediaStyle extends Style {
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        Token mToken;

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        public MediaStyle(android.support.v4.app.NotificationCompat.Builder builder) {
            this.mActionsToShowInCompact = null;
            setBuilder(builder);
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
    }

    private static class IceCreamSandwichExtender extends BuilderExtender {
        IceCreamSandwichExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews access$300 = NotificationCompat.addStyleGetContentViewIcs(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (access$300 != null) {
                build.contentView = access$300;
            } else if (builder.getContentView() != null) {
                build.contentView = builder.getContentView();
            }
            return build;
        }
    }

    private static class JellybeanExtender extends BuilderExtender {
        JellybeanExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews access$400 = NotificationCompat.addStyleGetContentViewJellybean(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (access$400 != null) {
                build.contentView = access$400;
            }
            NotificationCompat.addBigStyleToBuilderJellybean(build, builder);
            return build;
        }
    }

    private static class LollipopExtender extends BuilderExtender {
        LollipopExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews access$600 = NotificationCompat.addStyleGetContentViewLollipop(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (access$600 != null) {
                build.contentView = access$600;
            }
            NotificationCompat.addBigStyleToBuilderLollipop(build, builder);
            NotificationCompat.addHeadsUpToBuilderLollipop(build, builder);
            return build;
        }
    }

    @TargetApi(16)
    private static void addBigStyleToBuilderJellybean(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            RemoteViews bigContentView = builder.getBigContentView() != null ? builder.getBigContentView() : builder.getContentView();
            boolean z = (builder.mStyle instanceof DecoratedMediaCustomViewStyle) && bigContentView != null;
            NotificationCompatImplBase.overrideMediaBigContentView(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder.mActions, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, z);
            if (z) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, notification.bigContentView, bigContentView);
            }
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedBigStyleToBuilderJellybean(notification, builder);
        }
    }

    @TargetApi(21)
    private static void addBigStyleToBuilderLollipop(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        RemoteViews bigContentView = builder.getBigContentView() != null ? builder.getBigContentView() : builder.getContentView();
        if ((builder.mStyle instanceof DecoratedMediaCustomViewStyle) && bigContentView != null) {
            NotificationCompatImplBase.overrideMediaBigContentView(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder.mActions, false, null, true);
            NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, notification.bigContentView, bigContentView);
            setBackgroundColor(builder.mContext, notification.bigContentView, builder.getColor());
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedBigStyleToBuilderJellybean(notification, builder);
        }
    }

    @TargetApi(16)
    private static void addDecoratedBigStyleToBuilderJellybean(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        RemoteViews bigContentView = builder.getBigContentView();
        if (bigContentView == null) {
            bigContentView = builder.getContentView();
        }
        if (bigContentView != null) {
            RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, notification.icon, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), C0627R.layout.notification_template_custom_big, false, builder.mActions);
            NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, applyStandardTemplateWithActions, bigContentView);
            notification.bigContentView = applyStandardTemplateWithActions;
        }
    }

    @TargetApi(21)
    private static void addDecoratedHeadsUpToBuilderLollipop(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        RemoteViews headsUpContentView = builder.getHeadsUpContentView();
        RemoteViews contentView = headsUpContentView != null ? headsUpContentView : builder.getContentView();
        if (headsUpContentView != null) {
            headsUpContentView = NotificationCompatImplBase.applyStandardTemplateWithActions(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, notification.icon, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), C0627R.layout.notification_template_custom_big, false, builder.mActions);
            NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, headsUpContentView, contentView);
            notification.headsUpContentView = headsUpContentView;
        }
    }

    @TargetApi(21)
    private static void addHeadsUpToBuilderLollipop(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        RemoteViews headsUpContentView = builder.getHeadsUpContentView() != null ? builder.getHeadsUpContentView() : builder.getContentView();
        if ((builder.mStyle instanceof DecoratedMediaCustomViewStyle) && headsUpContentView != null) {
            notification.headsUpContentView = NotificationCompatImplBase.generateMediaBigView(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder.mActions, false, null, true);
            NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, notification.headsUpContentView, headsUpContentView);
            setBackgroundColor(builder.mContext, notification.headsUpContentView, builder.getColor());
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedHeadsUpToBuilderLollipop(notification, builder);
        }
    }

    private static void addMessagingFallBackStyle(MessagingStyle messagingStyle, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        List messages = messagingStyle.getMessages();
        int i = (messagingStyle.getConversationTitle() != null || hasMessagesWithoutSender(messagingStyle.getMessages())) ? 1 : 0;
        for (int size = messages.size() - 1; size >= 0; size--) {
            Message message = (Message) messages.get(size);
            CharSequence makeMessageLine = i != 0 ? makeMessageLine(builder, messagingStyle, message) : message.getText();
            if (size != messages.size() - 1) {
                spannableStringBuilder.insert(0, "\n");
            }
            spannableStringBuilder.insert(0, makeMessageLine);
        }
        NotificationCompatImplJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, spannableStringBuilder);
    }

    @TargetApi(14)
    private static RemoteViews addStyleGetContentViewIcs(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            boolean z = (builder.mStyle instanceof DecoratedMediaCustomViewStyle) && builder.getContentView() != null;
            RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.mActions, mediaStyle.mActionsToShowInCompact, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, z);
            if (z) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, overrideContentViewMedia, builder.getContentView());
                return overrideContentViewMedia;
            }
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            return getDecoratedContentView(builder);
        }
        return null;
    }

    @TargetApi(16)
    private static RemoteViews addStyleGetContentViewJellybean(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MessagingStyle) {
            addMessagingFallBackStyle((MessagingStyle) builder.mStyle, notificationBuilderWithBuilderAccessor, builder);
        }
        return addStyleGetContentViewIcs(notificationBuilderWithBuilderAccessor, builder);
    }

    @TargetApi(21)
    private static RemoteViews addStyleGetContentViewLollipop(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        if (!(builder.mStyle instanceof MediaStyle)) {
            return builder.mStyle instanceof DecoratedCustomViewStyle ? getDecoratedContentView(builder) : addStyleGetContentViewJellybean(notificationBuilderWithBuilderAccessor, builder);
        } else {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            NotificationCompatImpl21.addMediaStyle(notificationBuilderWithBuilderAccessor, mediaStyle.mActionsToShowInCompact, mediaStyle.mToken != null ? mediaStyle.mToken.m1097a() : null);
            boolean z = builder.getContentView() != null;
            Object obj = (VERSION.SDK_INT < 21 || VERSION.SDK_INT > 23) ? null : 1;
            obj = (z || !(obj == null || builder.getBigContentView() == null)) ? 1 : null;
            if (!(builder.mStyle instanceof DecoratedMediaCustomViewStyle) || obj == null) {
                return null;
            }
            RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.mActions, mediaStyle.mActionsToShowInCompact, false, null, z);
            if (z) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, overrideContentViewMedia, builder.getContentView());
            }
            setBackgroundColor(builder.mContext, overrideContentViewMedia, builder.getColor());
            return overrideContentViewMedia;
        }
    }

    @TargetApi(24)
    private static void addStyleToBuilderApi24(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedCustomViewStyle(notificationBuilderWithBuilderAccessor);
        } else if (builder.mStyle instanceof DecoratedMediaCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedMediaCustomViewStyle(notificationBuilderWithBuilderAccessor);
        } else if (!(builder.mStyle instanceof MessagingStyle)) {
            addStyleGetContentViewLollipop(notificationBuilderWithBuilderAccessor, builder);
        }
    }

    private static Message findLatestIncomingMessage(MessagingStyle messagingStyle) {
        List messages = messagingStyle.getMessages();
        for (int size = messages.size() - 1; size >= 0; size--) {
            Message message = (Message) messages.get(size);
            if (!TextUtils.isEmpty(message.getSender())) {
                return message;
            }
        }
        return !messages.isEmpty() ? (Message) messages.get(messages.size() - 1) : null;
    }

    private static RemoteViews getDecoratedContentView(android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.getContentView() == null) {
            return null;
        }
        RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mNotification.icon, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), C0627R.layout.notification_template_custom_big, false, null);
        NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, applyStandardTemplateWithActions, builder.getContentView());
        return applyStandardTemplateWithActions;
    }

    public static Token getMediaSession(Notification notification) {
        Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
        if (extras != null) {
            if (VERSION.SDK_INT >= 21) {
                Parcelable parcelable = extras.getParcelable(android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (parcelable != null) {
                    return Token.m1096a(parcelable);
                }
            }
            IBinder binder = BundleCompat.getBinder(extras, android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (binder != null) {
                Parcel obtain = Parcel.obtain();
                obtain.writeStrongBinder(binder);
                obtain.setDataPosition(0);
                Token token = (Token) Token.CREATOR.createFromParcel(obtain);
                obtain.recycle();
                return token;
            }
        }
        return null;
    }

    private static boolean hasMessagesWithoutSender(List<Message> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((Message) list.get(size)).getSender() == null) {
                return true;
            }
        }
        return false;
    }

    private static TextAppearanceSpan makeFontColorSpan(int i) {
        return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
    }

    private static CharSequence makeMessageLine(android.support.v4.app.NotificationCompat.Builder builder, MessagingStyle messagingStyle, Message message) {
        int i;
        CharSequence charSequence;
        C0275a a = C0275a.m928a();
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        Object obj = VERSION.SDK_INT >= 21 ? 1 : null;
        int i2 = (obj != null || VERSION.SDK_INT <= 10) ? -16777216 : -1;
        CharSequence sender = message.getSender();
        if (TextUtils.isEmpty(message.getSender())) {
            String userDisplayName = messagingStyle.getUserDisplayName() == null ? BuildConfig.VERSION_NAME : messagingStyle.getUserDisplayName();
            if (!(obj == null || builder.getColor() == 0)) {
                i2 = builder.getColor();
            }
            String str = userDisplayName;
            i = i2;
            charSequence = str;
        } else {
            CharSequence charSequence2 = sender;
            i = i2;
            charSequence = charSequence2;
        }
        charSequence = a.m938a(charSequence);
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - charSequence.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.append("  ").append(a.m938a(message.getText() == null ? BuildConfig.VERSION_NAME : message.getText()));
        return spannableStringBuilder;
    }

    private static void setBackgroundColor(Context context, RemoteViews remoteViews, int i) {
        if (i == 0) {
            i = context.getResources().getColor(C0627R.color.notification_material_background_media_default_color);
        }
        remoteViews.setInt(C0627R.id.status_bar_latest_event_content, "setBackgroundColor", i);
    }
}
