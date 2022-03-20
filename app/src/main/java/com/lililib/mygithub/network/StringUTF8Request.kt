package com.lililib.mygithub.network

import com.android.volley.toolbox.StringRequest
import com.android.volley.NetworkResponse
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.ParseError
import kotlin.Throws
import com.android.volley.AuthFailureError
import android.text.TextUtils
import com.android.volley.Response
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset
import java.util.HashMap

/**
 * Created by 阿銓.
 *
 * 一般的Volley的Request物件處理UTF8會亂碼，
 * 使用此Request物件可避免此Bug。
 *
 */
class StringUTF8Request : StringRequest {
    constructor(
        method: Int,
        url: String?,
        listener: Response.Listener<String?>?,
        errorListener: Response.ErrorListener?
    ) : super(method, url, listener, errorListener) {
    }

    constructor(
        url: String?,
        listener: Response.Listener<String?>?,
        errorListener: Response.ErrorListener?
    ) : super(url, listener, errorListener) {
    }

    override fun parseNetworkResponse(response: NetworkResponse): Response<String> {
        var utf8String: String? = null
        return try {
            utf8String = String(response.data, Charset.forName("UTF-8"))
            Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response))
        } catch (e: UnsupportedEncodingException) {
            Response.error(ParseError(e))
        }
    }

    @Throws(AuthFailureError::class)
    override fun getHeaders(): Map<String, String> {
        return if (myHeader == null || myHeader!!.size <= 0) {
            super.getHeaders()
        } else myHeader!!
    }

    @Throws(AuthFailureError::class)
    override fun getParams(): Map<String, String>? {
        return if (myParams == null || myParams!!.size <= 0) {
            super.getParams()
        } else myParams
    }

    @Throws(AuthFailureError::class)
    override fun getBody(): ByteArray {
        return if (!TextUtils.isEmpty(myBody)) {
            myBody!!.toByteArray()
        } else super.getBody()
    }

    private var myHeader: MutableMap<String, String>? = null
    fun addHeader(key: String, value: String) {
        if (myHeader == null) {
            myHeader = HashMap()
        }
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return
        }
        myHeader!![key] = value
    }

    private var myParams: MutableMap<String, String>? = null
    fun addParam(key: String, value: String) {
        if (myParams == null) {
            myParams = HashMap()
        }
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return
        }
        myParams!![key] = value
    }

    private var myBody: String? = null
    fun setBody(body: String?) {
        myBody = body
    }
}