package com.chenluo.commontookkit.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * 全局统一日志
 */
public class LCLog {
    public static String customTagPrefix = "LCLog";

    private static boolean DEBUG = true;

    private static LCLog mInstance = null;

    public LCLog() {
    }

   /* public static void init(String filePath) {
        if (null != mInstance) {
            return;
        }
        mInstance = new LCLog(filePath);
    }*/

    public static void init() {
        if (null != mInstance) {
            return;
        }
        mInstance = new LCLog();
    }

    public static void enableLog2Console(boolean debug) {
        DEBUG = debug;
    }

    public static void e(String tag, String desc) {
        if (DEBUG) {
            if (mInstance == null) {
                Log.e(tag, desc);
            } else {
                mInstance.e(tag, desc);
            }
        }
    }

    public static void e(String desc) {
        if (DEBUG) {
            String tag = generateTag();
            if (mInstance == null) {
                Log.e(tag, desc);
            } else {
                mInstance.e(tag, desc);
            }
        }
    }

    public static void w(String tag, String desc) {
        if (DEBUG) {
            if (mInstance == null) {
                Log.w(tag, desc);
            } else {
                mInstance.w(tag, desc);
            }
        }
    }

    public static void w(String desc) {
        if (DEBUG) {
            String tag = generateTag();
            if (mInstance == null) {
                Log.w(tag, desc);
            } else {
                mInstance.w(tag, desc);
            }
        }
    }

    public static void i(String tag, String desc) {
        if (DEBUG) {
            if (mInstance == null) {
                Log.i(tag, desc);
            } else {
                mInstance.i(tag, desc);
            }
        }
    }

    public static void i(String desc) {
        if (DEBUG) {
            String tag = generateTag();
            if (mInstance == null) {
                Log.i(tag, desc);
            } else {
                mInstance.i(tag, desc);
            }
        }
    }

    public static void d(String tag, String desc) {
        if (DEBUG) {
            if (mInstance == null) {
                Log.d(tag, desc);
            } else {
                mInstance.d(tag, desc);
            }
        }
    }

    public static void d(String desc) {
        if (DEBUG) {
            String tag = generateTag();
            if (mInstance == null) {
                Log.d(tag, desc);
            } else {
                mInstance.d(tag, desc);
            }
        }
    }

    public static void v(String tag, String desc) {
        if (DEBUG) {
            if (mInstance == null) {
                Log.v(tag, desc);
            } else {
                mInstance.v(tag, desc);
            }
        }
    }

    public static void v(String desc) {
        if (DEBUG) {
            String tag = generateTag();
            if (mInstance == null) {
                Log.v(tag, desc);
            } else {
                mInstance.v(tag, desc);
            }
        }
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }
}
