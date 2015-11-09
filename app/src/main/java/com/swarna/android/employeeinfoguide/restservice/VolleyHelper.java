package com.swarna.android.employeeinfoguide.restservice;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.swarna.android.employeeinfoguide.asyncimage.BitmapLruCache;

public class VolleyHelper {
	private static VolleyHelper INSTANCE;
	private RequestQueue requestQueue;
	private Context context;
	private static final int MAX_IMAGE_CACHE_ENTIRES = 100;
	private static ImageLoader mImageLoader;

	private VolleyHelper(Context context){
		this.context = context;
		requestQueue = getRequestQueue();

	}

	public static synchronized VolleyHelper getInstance(Context context){
		if(INSTANCE == null){
			INSTANCE = new VolleyHelper(context);
		}
		return INSTANCE;
	}

	public RequestQueue getRequestQueue(){
		if(requestQueue == null){
			requestQueue = Volley.newRequestQueue(context.getApplicationContext());
		}
		return requestQueue;
	}

	/**
	 * Returns instance of ImageLoader initialized with {@see FakeImageCache} which effectively means
	 * that no memory caching is used. This is useful for images that you know that will be show
	 * only once.
	 */
	public ImageLoader getImageLoader() {
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(getRequestQueue(), new BitmapLruCache(MAX_IMAGE_CACHE_ENTIRES));
		}
		return mImageLoader;
	}

	public <T> void addToRequestQueue(Request<T> req) {
		getRequestQueue().add(req);
	}
}
