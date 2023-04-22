package a.gautham.statusdownloader.Fragments;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.material.button.MaterialButton;

import a.gautham.statusdownloader.MainActivity;
import a.gautham.statusdownloader.R;


public class WhatsappFragment extends Fragment {

    private  View view;
    private MaterialButton SendMessageBtn;
    private EditText countryCode, PhoneNumber, TextMessage;
    private AdView adView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_whatsapp, container, false);
        SendMessageBtn = view.findViewById(R.id.SendMessageBtn);
        countryCode = view.findViewById(R.id.countryCode);
        PhoneNumber = view.findViewById(R.id.PhoneNumber);
        TextMessage = view.findViewById(R.id.TextMessage);



        SendMessageBtn.setOnClickListener(view -> {
            PackageManager pm=getContext(). getPackageManager();
            try {


                String toNumber = PhoneNumber.getText().toString();
                String usercountryCode = countryCode.getText().toString();
                String message = TextMessage.getText().toString();


                if(usercountryCode.startsWith("+")){
                    usercountryCode = usercountryCode.replace("+", "");
                }
                if(toNumber.startsWith(usercountryCode)){
                    toNumber = toNumber.replace(usercountryCode, "");

                }
                if(toNumber.startsWith("0")){
                    toNumber = toNumber.replaceFirst("0", "");

                }
                toNumber = usercountryCode+toNumber;
                Log.d(TAG, "onCreateView: "+toNumber);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber.replaceAll(" ", "") +"&text="+message));
                startActivity(sendIntent);

        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getContext(),"it may be you don't have Whatsapp",Toast.LENGTH_LONG).show();

        }
        });

        return view;
    }


}