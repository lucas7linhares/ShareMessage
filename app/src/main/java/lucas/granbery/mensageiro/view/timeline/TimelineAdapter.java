package lucas.granbery.mensageiro.view.timeline;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import lucas.granbery.mensageiro.R;
import lucas.granbery.mensageiro.domain.model.Message;
import lucas.granbery.mensageiro.util.LocaleProvider;

import java.text.SimpleDateFormat;
import java.util.List;

public class TimelineAdapter extends ArrayAdapter<Message> {

    private static final String TAG = TimelineAdapter.class.getName();

    private final Context context;
    private final List<Message> statuses;
    private final SimpleDateFormat formatter;


    public TimelineAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);

        this.context = context;
        this.statuses = objects;
        formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyy", LocaleProvider.get(context));
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {



        if (view == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(R.layout.fragment_timeline_item,parent, false);
        }

        Message statusMessage = statuses.get(position);
        Log.d(TAG, statusMessage.toString());

        TextView author = (TextView) view.findViewById(R.id.list_item_text_user);
        author.setText(statusMessage.getAuthor());

        TextView message = (TextView) view.findViewById(R.id.list_item_text_message);
        message.setText(statusMessage.getMessage());

        TextView createdAt = (TextView) view.findViewById(R.id.list_item_text_created_at);
        createdAt.setText(formatter.format(statusMessage.getCreatedAt()));

        return view;

    }
}
