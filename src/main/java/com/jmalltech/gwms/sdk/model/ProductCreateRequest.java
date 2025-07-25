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


package com.jmalltech.gwms.sdk.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.jmalltech.gwms.sdk.model.Attributes;
import com.jmalltech.gwms.sdk.model.Dimensions;
import com.jmalltech.gwms.sdk.model.Packaging;
import com.jmalltech.gwms.sdk.model.Pricing;
import com.jmalltech.gwms.sdk.model.Weight;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
import javax.validation.constraints.*;
import javax.validation.Valid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jmalltech.gwms.sdk.invoker.JSON;

/**
 * ProductCreateRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProductCreateRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_PARAMS = "params";
  @SerializedName(SERIALIZED_NAME_PARAMS)
  private Map<String, Object> params = new HashMap<>();

  public static final String SERIALIZED_NAME_SPU_CODE = "spuCode";
  @SerializedName(SERIALIZED_NAME_SPU_CODE)
  private String spuCode;

  public static final String SERIALIZED_NAME_UPC = "upc";
  @SerializedName(SERIALIZED_NAME_UPC)
  private String upc;

  public static final String SERIALIZED_NAME_SKU = "sku";
  @SerializedName(SERIALIZED_NAME_SKU)
  private String sku;

  public static final String SERIALIZED_NAME_AMAZON_FN_SKU = "amazonFnSku";
  @SerializedName(SERIALIZED_NAME_AMAZON_FN_SKU)
  private String amazonFnSku;

  public static final String SERIALIZED_NAME_SERIAL_NUMBER = "serialNumber";
  @SerializedName(SERIALIZED_NAME_SERIAL_NUMBER)
  private String serialNumber;

  public static final String SERIALIZED_NAME_DIMENSIONS = "dimensions";
  @SerializedName(SERIALIZED_NAME_DIMENSIONS)
  private Dimensions dimensions;

  public static final String SERIALIZED_NAME_WEIGHT = "weight";
  @SerializedName(SERIALIZED_NAME_WEIGHT)
  private Weight weight;

  public static final String SERIALIZED_NAME_PACKAGING = "packaging";
  @SerializedName(SERIALIZED_NAME_PACKAGING)
  private Packaging packaging;

  public static final String SERIALIZED_NAME_PRICING = "pricing";
  @SerializedName(SERIALIZED_NAME_PRICING)
  private Pricing pricing;

  public static final String SERIALIZED_NAME_ATTRIBUTES = "attributes";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTES)
  private Attributes attributes;

  public static final String SERIALIZED_NAME_IMAGE_URL = "imageUrl";
  @SerializedName(SERIALIZED_NAME_IMAGE_URL)
  private String imageUrl;

  public ProductCreateRequest() {
  }

  public ProductCreateRequest params(Map<String, Object> params) {
    this.params = params;
    return this;
  }

  public ProductCreateRequest putParamsItem(String key, Object paramsItem) {
    if (this.params == null) {
      this.params = new HashMap<>();
    }
    this.params.put(key, paramsItem);
    return this;
  }

   /**
   * 扩展参数，Map&lt;String, Object&gt;类型，用于后期扩展
   * @return params
  **/
  @javax.annotation.Nullable

  public Map<String, Object> getParams() {
    return params;
  }

  public void setParams(Map<String, Object> params) {
    this.params = params;
  }


  public ProductCreateRequest spuCode(String spuCode) {
    this.spuCode = spuCode;
    return this;
  }

   /**
   * SPU编码，关联产品SPU。使用业务编码耏非内部ID。
   * @return spuCode
  **/
  @javax.annotation.Nonnull
  @NotNull
 @Pattern(regexp="^[A-Za-z0-9-]{1,50}$") @Size(min=1,max=50)
  public String getSpuCode() {
    return spuCode;
  }

  public void setSpuCode(String spuCode) {
    this.spuCode = spuCode;
  }


  public ProductCreateRequest upc(String upc) {
    this.upc = upc;
    return this;
  }

   /**
   * 通用产品代码。
   * @return upc
  **/
  @javax.annotation.Nullable
 @Pattern(regexp="^\\d{12}$") @Size(min=12,max=12)
  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }


  public ProductCreateRequest sku(String sku) {
    this.sku = sku;
    return this;
  }

   /**
   * 库存单位。产品的唯一的内部标识符。
   * @return sku
  **/
  @javax.annotation.Nonnull
  @NotNull
 @Pattern(regexp="^[A-Za-z0-9-]{1,50}$") @Size(min=1,max=50)
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }


  public ProductCreateRequest amazonFnSku(String amazonFnSku) {
    this.amazonFnSku = amazonFnSku;
    return this;
  }

   /**
   * Amazon FN SKU。
   * @return amazonFnSku
  **/
  @javax.annotation.Nullable
 @Pattern(regexp="^[A-Za-z0-9-]{1,50}$") @Size(min=1,max=50)
  public String getAmazonFnSku() {
    return amazonFnSku;
  }

  public void setAmazonFnSku(String amazonFnSku) {
    this.amazonFnSku = amazonFnSku;
  }


  public ProductCreateRequest serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

   /**
   * 序列号。
   * @return serialNumber
  **/
  @javax.annotation.Nullable
 @Pattern(regexp="^[A-Z0-9-]{1,100}$") @Size(min=1,max=100)
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }


  public ProductCreateRequest dimensions(Dimensions dimensions) {
    this.dimensions = dimensions;
    return this;
  }

   /**
   * Get dimensions
   * @return dimensions
  **/
  @javax.annotation.Nullable
  @Valid

  public Dimensions getDimensions() {
    return dimensions;
  }

  public void setDimensions(Dimensions dimensions) {
    this.dimensions = dimensions;
  }


  public ProductCreateRequest weight(Weight weight) {
    this.weight = weight;
    return this;
  }

   /**
   * Get weight
   * @return weight
  **/
  @javax.annotation.Nullable
  @Valid

  public Weight getWeight() {
    return weight;
  }

  public void setWeight(Weight weight) {
    this.weight = weight;
  }


  public ProductCreateRequest packaging(Packaging packaging) {
    this.packaging = packaging;
    return this;
  }

   /**
   * Get packaging
   * @return packaging
  **/
  @javax.annotation.Nonnull
  @NotNull
  @Valid

  public Packaging getPackaging() {
    return packaging;
  }

  public void setPackaging(Packaging packaging) {
    this.packaging = packaging;
  }


  public ProductCreateRequest pricing(Pricing pricing) {
    this.pricing = pricing;
    return this;
  }

   /**
   * Get pricing
   * @return pricing
  **/
  @javax.annotation.Nullable
  @Valid

  public Pricing getPricing() {
    return pricing;
  }

  public void setPricing(Pricing pricing) {
    this.pricing = pricing;
  }


  public ProductCreateRequest attributes(Attributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @javax.annotation.Nullable
  @Valid

  public Attributes getAttributes() {
    return attributes;
  }

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }


  public ProductCreateRequest imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

   /**
   * 产品图片URL。
   * @return imageUrl
  **/
  @javax.annotation.Nullable
 @Pattern(regexp="^https?://.+") @Size(min=10,max=2048)
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductCreateRequest productCreateRequest = (ProductCreateRequest) o;
    return Objects.equals(this.params, productCreateRequest.params) &&
        Objects.equals(this.spuCode, productCreateRequest.spuCode) &&
        Objects.equals(this.upc, productCreateRequest.upc) &&
        Objects.equals(this.sku, productCreateRequest.sku) &&
        Objects.equals(this.amazonFnSku, productCreateRequest.amazonFnSku) &&
        Objects.equals(this.serialNumber, productCreateRequest.serialNumber) &&
        Objects.equals(this.dimensions, productCreateRequest.dimensions) &&
        Objects.equals(this.weight, productCreateRequest.weight) &&
        Objects.equals(this.packaging, productCreateRequest.packaging) &&
        Objects.equals(this.pricing, productCreateRequest.pricing) &&
        Objects.equals(this.attributes, productCreateRequest.attributes) &&
        Objects.equals(this.imageUrl, productCreateRequest.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(params, spuCode, upc, sku, amazonFnSku, serialNumber, dimensions, weight, packaging, pricing, attributes, imageUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCreateRequest {\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    spuCode: ").append(toIndentedString(spuCode)).append("\n");
    sb.append("    upc: ").append(toIndentedString(upc)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    amazonFnSku: ").append(toIndentedString(amazonFnSku)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    dimensions: ").append(toIndentedString(dimensions)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    packaging: ").append(toIndentedString(packaging)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("params");
    openapiFields.add("spuCode");
    openapiFields.add("upc");
    openapiFields.add("sku");
    openapiFields.add("amazonFnSku");
    openapiFields.add("serialNumber");
    openapiFields.add("dimensions");
    openapiFields.add("weight");
    openapiFields.add("packaging");
    openapiFields.add("pricing");
    openapiFields.add("attributes");
    openapiFields.add("imageUrl");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("spuCode");
    openapiRequiredFields.add("sku");
    openapiRequiredFields.add("packaging");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ProductCreateRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ProductCreateRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProductCreateRequest is not found in the empty JSON string", ProductCreateRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ProductCreateRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ProductCreateRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ProductCreateRequest.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("spuCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `spuCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("spuCode").toString()));
      }
      if ((jsonObj.get("upc") != null && !jsonObj.get("upc").isJsonNull()) && !jsonObj.get("upc").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `upc` to be a primitive type in the JSON string but got `%s`", jsonObj.get("upc").toString()));
      }
      if (!jsonObj.get("sku").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sku` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sku").toString()));
      }
      if ((jsonObj.get("amazonFnSku") != null && !jsonObj.get("amazonFnSku").isJsonNull()) && !jsonObj.get("amazonFnSku").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `amazonFnSku` to be a primitive type in the JSON string but got `%s`", jsonObj.get("amazonFnSku").toString()));
      }
      if ((jsonObj.get("serialNumber") != null && !jsonObj.get("serialNumber").isJsonNull()) && !jsonObj.get("serialNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `serialNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("serialNumber").toString()));
      }
      // validate the optional field `dimensions`
      if (jsonObj.get("dimensions") != null && !jsonObj.get("dimensions").isJsonNull()) {
        Dimensions.validateJsonElement(jsonObj.get("dimensions"));
      }
      // validate the optional field `weight`
      if (jsonObj.get("weight") != null && !jsonObj.get("weight").isJsonNull()) {
        Weight.validateJsonElement(jsonObj.get("weight"));
      }
      // validate the required field `packaging`
      Packaging.validateJsonElement(jsonObj.get("packaging"));
      // validate the optional field `pricing`
      if (jsonObj.get("pricing") != null && !jsonObj.get("pricing").isJsonNull()) {
        Pricing.validateJsonElement(jsonObj.get("pricing"));
      }
      // validate the optional field `attributes`
      if (jsonObj.get("attributes") != null && !jsonObj.get("attributes").isJsonNull()) {
        Attributes.validateJsonElement(jsonObj.get("attributes"));
      }
      if ((jsonObj.get("imageUrl") != null && !jsonObj.get("imageUrl").isJsonNull()) && !jsonObj.get("imageUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `imageUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("imageUrl").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProductCreateRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProductCreateRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProductCreateRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProductCreateRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<ProductCreateRequest>() {
           @Override
           public void write(JsonWriter out, ProductCreateRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ProductCreateRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ProductCreateRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProductCreateRequest
  * @throws IOException if the JSON string is invalid with respect to ProductCreateRequest
  */
  public static ProductCreateRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProductCreateRequest.class);
  }

 /**
  * Convert an instance of ProductCreateRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

