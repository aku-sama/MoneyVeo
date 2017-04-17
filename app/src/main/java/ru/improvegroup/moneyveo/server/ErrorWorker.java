package ru.improvegroup.moneyveo.server;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;
import ru.improvegroup.moneyveo.R;
import ru.improvegroup.moneyveo.app.VeoApplication;
import ru.improvegroup.moneyveo.server.entity.BasicReason;
import ru.improvegroup.moneyveo.server.entity.BasicResponse;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class ErrorWorker {
    private final static String CODE_0_101 = "0.101";
    private final static String CODE_0_102 = "0.102";
    private final static String CODE_1_0 = "1.0";
    private final static String CODE_1_101 = "1.101";
    private final static String CODE_1_102 = "1.102";
    private final static String CODE_1_103 = "1.103";
    private final static String CODE_1_104 = "1.104";
    private final static String CODE_7_101 = "7.101";
    private final static String CODE_7_102 = "7.102";
    private final static String CODE_2_0 = "2.0";
    private final static String CODE_2_1 = "2.1";
    private final static String CODE_2_2 = "2.2";
    private final static String CODE_2_101 = "2.101";
    private final static String CODE_2_102 = "2.102";
    private final static String CODE_2_103 = "2.103";
    private final static String CODE_2_104 = "2.104";
    private final static String CODE_2_105 = "2.105";
    private final static String CODE_2_106 = "2.106";
    private final static String CODE_2_107 = "2.107";
    private final static String CODE_2_108 = "2.108";
    private final static String CODE_4_101 = "4.101";
    private final static String CODE_4_102 = "4.102";
    private final static String CODE_4_103 = "4.103";
    private final static String CODE_4_104 = "4.104";
    private final static String CODE_4_105 = "4.105";
    private final static String CODE_4_106 = "4.106";
    private final static String CODE_4_107 = "4.107";
    private final static String CODE_4_108 = "4.108";
    private final static String CODE_4_109 = "4.109";
    private final static String CODE_4_110 = "4.110";
    private final static String CODE_5_101 = "5.101";
    private final static String CODE_5_102 = "5.102";
    private final static String CODE_6_0 = "6.0";
    private final static String CODE_6_1 = "6.1";
    private final static String CODE_6_2 = "6.2";
    private final static String CODE_6_3 = "6.3";
    private final static String CODE_3_101 = "3.101";
    private final static String CODE_3_102 = "3.102";
    private final static String CODE_3_103 = "3.103";
    private final static String CODE_3_104 = "3.104";


    public static String getErrorMessage(final BasicResponse responseErrorBody, final ResponseBody error) {

        if (responseErrorBody != null) {
            BasicReason reason = responseErrorBody.getReasons().get(0);
            return getError(reason.getCode());

        } else if (error != null) {
            try {
                String json = error.string();
                Gson gson = new Gson();
                BasicResponse reason = null;

                reason = gson.fromJson(json, BasicResponse.class);
                return getError(reason.getReasons().get(0).getCode());
            } catch (IOException e) {
                e.printStackTrace();
                return getDefaultError();
            }
        } else
            return getDefaultError();
    }

    private static String getError(String code) {
        Resources resources = VeoApplication.getInstance().getResources();
        switch (code) {
            case CODE_0_101:
                return resources.getString(R.string.error_0_101);
            case CODE_0_102:
                return resources.getString(R.string.error_0_102);
            case CODE_1_0:
                return resources.getString(R.string.error_1_0);
            case CODE_1_101:
                return resources.getString(R.string.error_1_101);
            case CODE_1_102:
                return resources.getString(R.string.error_1_102);
            case CODE_1_103:
                return resources.getString(R.string.error_1_103);
            case CODE_1_104:
                return resources.getString(R.string.error_1_104);
            case CODE_2_0:
                return resources.getString(R.string.error_2_0);
            case CODE_2_1:
                return resources.getString(R.string.error_2_1);
            case CODE_2_2:
                return resources.getString(R.string.error_2_2);
            case CODE_2_101:
                return resources.getString(R.string.error_2_101);
            case CODE_2_102:
                return resources.getString(R.string.error_2_102);
            case CODE_2_103:
                return resources.getString(R.string.error_2_103);
            case CODE_2_104:
                return resources.getString(R.string.error_2_104);
            case CODE_2_105:
                return resources.getString(R.string.error_2_105);
            case CODE_2_106:
                return resources.getString(R.string.error_2_106);
            case CODE_2_107:
                return resources.getString(R.string.error_2_107);
            case CODE_2_108:
                return resources.getString(R.string.error_2_108);
            case CODE_3_101:
                return resources.getString(R.string.error_3_101);
            case CODE_3_102:
                return resources.getString(R.string.error_3_102);
            case CODE_3_103:
                return resources.getString(R.string.error_3_103);
            case CODE_3_104:
                return resources.getString(R.string.error_3_104);
            case CODE_4_101:
                return resources.getString(R.string.error_4_101);
            case CODE_4_102:
                return resources.getString(R.string.error_4_102);
            case CODE_4_103:
                return resources.getString(R.string.error_4_103);
            case CODE_4_104:
                return resources.getString(R.string.error_4_104);
            case CODE_4_105:
                return resources.getString(R.string.error_4_105);
            case CODE_4_106:
                return resources.getString(R.string.error_4_106);
            case CODE_4_107:
                return resources.getString(R.string.error_4_107);
            case CODE_4_108:
                return resources.getString(R.string.error_4_108);
            case CODE_4_109:
                return resources.getString(R.string.error_4_109);
            case CODE_4_110:
                return resources.getString(R.string.error_4_110);
            case CODE_5_101:
                return resources.getString(R.string.error_5_101);
            case CODE_5_102:
                return resources.getString(R.string.error_5_102);
            case CODE_6_0:
                return resources.getString(R.string.error_6_0);
            case CODE_6_1:
                return resources.getString(R.string.error_6_1);
            case CODE_6_2:
                return resources.getString(R.string.error_6_2);
            case CODE_6_3:
                return resources.getString(R.string.error_6_3);
            case CODE_7_101:
                return resources.getString(R.string.error_7_101);
            case CODE_7_102:
                return resources.getString(R.string.error_7_102);
            default:
                return getDefaultError();
        }
    }

    private static String getDefaultError() {
        Context context = VeoApplication.getInstance();
        return context.getResources().getString(R.string.error_999);
    }
}
