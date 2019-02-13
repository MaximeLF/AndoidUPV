package listViewControlleur;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practica2.Quotation;
import com.example.practica2.R;

import java.util.List;

public class CustomAdapteur extends ArrayAdapter {
    private int layout;

    public CustomAdapteur(Context context, int i, List<Quotation> list){
        super(context,i,list);
        layout = i;
    }

    private class ViewHolder{
        private TextView text;
        private TextView author;

        private TextView getText() {
            return text;
        }

        private void setText(TextView text) {
            this.text = text;
        }

        private TextView getAuthor() {
            return author;
        }

        private void setAuthor(TextView author) {
            this.author = author;
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layout, null);
            ViewHolder vh = new ViewHolder();
            vh.setAuthor((TextView) view.findViewById(R.id.quote_author));
            vh.setText((TextView) view.findViewById(R.id.quote_text));
            view.setTag(vh);

        }
        ViewHolder views = (ViewHolder)(view.getTag());
        TextView text = views.getText();
        TextView author = views.getAuthor();
        Quotation quote = (Quotation)getItem(position);
        Log.e("test_list",views.toString());
        Log.e("test_list",quote.getQuoteText());
        text.setText(quote.getQuoteText());
        author.setText(quote.getQuoteAuthor());


        return view;
    }
}
