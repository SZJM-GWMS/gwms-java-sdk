/*
 * GWMS Public API
 * GWMS（仓库管理系统）的官方公开API。 它为ERP、电子商务平台和TMS等外部系统提供了一个标准化、健壮且易于集成的接口，以便与WMS功能进行交互。  ## 认证机制  本API采用基于JWT的Bearer令牌认证，结合三重凭证验证机制：  1. **客户端凭证（Client Credentials）**：由系统管理员为上游系统生成的clientId和clientSecret 2. **API密钥（API Key）**：由仓库用户生成，关联到特定仓库和权限范围 3. **访问令牌（Access Token）**：通过认证端点获取的JWT令牌，用于API访问  ## 快速开始  1. **获取凭证**：联系系统管理员获取clientId和clientSecret，联系仓库用户获取apiKey 2. **获取令牌**：调用 `POST /auth-api/token` 端点获取访问令牌 3. **调用API**：在请求头中添加 `Authorization: Bearer {access_token}` 调用其他API  ## 认证头部格式  所有API请求（除了认证端点）必须包含以下HTTP头部：  ``` Authorization: Bearer {access_token} ```  其中`{access_token}`是从认证端点获取的JWT令牌。缺少此头部或令牌无效将导致401错误。  ## 权限范围  API访问权限基于以下范围进行控制：  | 权限范围 | 描述 | 适用API | 示例操作 | |---------|------|---------|---------| | `product:read` | 产品数据读取权限 | `/api/v1/products/_*` | 查询产品列表、获取产品详情 | | `product:write` | 产品数据写入权限 | `/api/v1/products/_*` | 创建产品、更新产品信息 | | `warehouse:read` | 仓库数据读取权限 | `/api/v1/warehouses/_*` | 查询仓库列表、获取仓库详情 | | `warehouse:write` | 仓库数据写入权限 | `/api/v1/warehouses/_*` | 创建仓库、更新仓库信息 | | `stock:read` | 库存数据读取权限 | `/api/v1/stock/_*` | 查询库存数量、库存明细 | | `stock:write` | 库存数据写入权限 | `/api/v1/stock/_*` | 库存调整、库存转移 | | `inbound:read` | 入库单读取权限 | `/api/v1/inbound/_*` | 查询入库单列表、获取入库单详情 | | `inbound:write` | 入库单写入权限 | `/api/v1/inbound/_*` | 创建入库单、更新入库单 | | `outbound:read` | 出库单读取权限 | `/api/v1/outbound/_*` | 查询出库单列表、获取出库单详情 | | `outbound:write` | 出库单写入权限 | `/api/v1/outbound/_*` | 创建出库单、更新出库单 | | `express:read` | 物流渠道读取权限 | `/api/v1/expressChannel/_*` | 查询物流渠道列表 | | `express:write` | 物流渠道写入权限 | `/api/v1/expressChannel/_*` | 创建物流渠道、更新物流渠道 |  ## 错误响应  认证失败时，API将返回以下错误响应：  - **401 Unauthorized**：令牌无效、过期或缺失 - **403 Forbidden**：令牌有效但权限不足 - **429 Too Many Requests**：超过访问频率限制  详细的错误响应格式请参考错误响应部分。 
 *
 * The version of the OpenAPI document: 1.0.3
 * Contact: api-support@jmalltech.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.jmalltech.gwms.sdk.invoker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonElement;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.TypeSelector;

import okio.ByteString;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

/*
 * A JSON utility class
 *
 * NOTE: in the future, this class may be converted to static, which may break
 *       backward-compatibility
 */
public class JSON {
    private static Gson gson;
    private static boolean isLenientOnJson = false;
    private static DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
    private static SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
    private static OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
    private static LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();
    private static ByteArrayAdapter byteArrayAdapter = new ByteArrayAdapter();

    @SuppressWarnings("unchecked")
    public static GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder()
        ;
        GsonBuilder builder = fireBuilder.createGsonBuilder();
        return builder;
    }

    private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
        JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
        if (null == element) {
            throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
        }
        return element.getAsString();
    }

    /**
     * Returns the Java class that implements the OpenAPI schema for the specified discriminator value.
     *
     * @param classByDiscriminatorValue The map of discriminator values to Java classes.
     * @param discriminatorValue The value of the OpenAPI discriminator in the input data.
     * @return The Java class that implements the OpenAPI schema
     */
    private static Class getClassByDiscriminator(Map classByDiscriminatorValue, String discriminatorValue) {
        Class clazz = (Class) classByDiscriminatorValue.get(discriminatorValue);
        if (null == clazz) {
            throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
        }
        return clazz;
    }

    {
        GsonBuilder gsonBuilder = createGson();
        gsonBuilder.registerTypeAdapter(Date.class, dateTypeAdapter);
        gsonBuilder.registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter);
        gsonBuilder.registerTypeAdapter(LocalDate.class, localDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(byte[].class, byteArrayAdapter);
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Address.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ApiErrorResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ApiListResponseBase.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ApiResponseBase.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Attributes.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Charge.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ChargeTransaction.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ChargeTransactionListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ChargeTransactionResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ContactInfo.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Dimensions.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Error.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ErrorDetail.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ExpressChannel.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ExtensibleRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundDimensions.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrder.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderBox.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderBoxCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderDetail.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderDetailCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderDetailResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderDetailResponseAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderStatusUpdateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundOrderUpdateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.InboundWeight.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Location.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.LocationCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.LocationListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.LocationResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.LocationUpdateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.OrderQueryVo.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.OutboundOrder.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.OutboundOrderDetail.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.OutboundOrderListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Packaging.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Pagination.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Pricing.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Product.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductBatchRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductBatchResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductBatchResponseAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductPartialUpdateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductSpu.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductSpuCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductSpuListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductSpuResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductSpuUpdateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ProductUpdateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.PublicBaseEntity.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.StockDetailInfo.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.StockInfo.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.StockPageListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.StockQueryRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.StockQueryResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.TokenRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.TokenResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Warehouse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.WarehouseCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.WarehouseListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.WarehouseResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.WarehouseUpdateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Weight.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.Zone.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ZoneCreateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ZoneListResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ZoneResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.jmalltech.gwms.sdk.model.ZoneUpdateRequest.CustomTypeAdapterFactory());
        gson = gsonBuilder.create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     */
    public static void setGson(Gson gson) {
        JSON.gson = gson;
    }

    public static void setLenientOnJson(boolean lenientOnJson) {
        isLenientOnJson = lenientOnJson;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public static String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String body, Type returnType) {
        try {
            if (isLenientOnJson) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            // return the response body string directly for the String return type;
            if (returnType.equals(String.class)) {
                return (T) body;
            } else {
                throw (e);
            }
        }
    }

    /**
     * Gson TypeAdapter for Byte Array type
     */
    public static class ByteArrayAdapter extends TypeAdapter<byte[]> {

        @Override
        public void write(JsonWriter out, byte[] value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(ByteString.of(value).base64());
            }
        }

        @Override
        public byte[] read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String bytesAsBase64 = in.nextString();
                    ByteString byteString = ByteString.decodeBase64(bytesAsBase64);
                    return byteString.toByteArray();
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 OffsetDateTime type
     */
    public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

        private DateTimeFormatter formatter;

        public OffsetDateTimeTypeAdapter() {
            this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, OffsetDateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public OffsetDateTime read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    if (date.endsWith("+0000")) {
                        date = date.substring(0, date.length()-5) + "Z";
                    }
                    return OffsetDateTime.parse(date, formatter);
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 LocalDate type
     */
    public static class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private DateTimeFormatter formatter;

        public LocalDateTypeAdapter() {
            this(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        public LocalDateTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return LocalDate.parse(date, formatter);
            }
        }
    }

    public static void setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        offsetDateTimeTypeAdapter.setFormat(dateFormat);
    }

    public static void setLocalDateFormat(DateTimeFormatter dateFormat) {
        localDateTypeAdapter.setFormat(dateFormat);
    }

    /**
     * Gson TypeAdapter for java.sql.Date type
     * If the dateFormat is null, a simple "yyyy-MM-dd" format will be used
     * (more efficient than SimpleDateFormat).
     */
    public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

        private DateFormat dateFormat;

        public SqlDateTypeAdapter() {}

        public SqlDateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, java.sql.Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = date.toString();
                }
                out.value(value);
            }
        }

        @Override
        public java.sql.Date read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    try {
                        if (dateFormat != null) {
                            return new java.sql.Date(dateFormat.parse(date).getTime());
                        }
                        return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
                    } catch (ParseException e) {
                        throw new JsonParseException(e);
                    }
            }
        }
    }

    /**
     * Gson TypeAdapter for java.util.Date type
     * If the dateFormat is null, ISO8601Utils will be used.
     */
    public static class DateTypeAdapter extends TypeAdapter<Date> {

        private DateFormat dateFormat;

        public DateTypeAdapter() {}

        public DateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = ISO8601Utils.format(date, true);
                }
                out.value(value);
            }
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            try {
                switch (in.peek()) {
                    case NULL:
                        in.nextNull();
                        return null;
                    default:
                        String date = in.nextString();
                        try {
                            if (dateFormat != null) {
                                return dateFormat.parse(date);
                            }
                            return ISO8601Utils.parse(date, new ParsePosition(0));
                        } catch (ParseException e) {
                            throw new JsonParseException(e);
                        }
                }
            } catch (IllegalArgumentException e) {
                throw new JsonParseException(e);
            }
        }
    }

    public static void setDateFormat(DateFormat dateFormat) {
        dateTypeAdapter.setFormat(dateFormat);
    }

    public static void setSqlDateFormat(DateFormat dateFormat) {
        sqlDateTypeAdapter.setFormat(dateFormat);
    }
}
