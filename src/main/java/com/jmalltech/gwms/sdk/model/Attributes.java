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
import java.io.IOException;
import java.util.Arrays;
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
 * 产品属性。
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Attributes implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_CONTAINING_ELECTRIC = "containingElectric";
  @SerializedName(SERIALIZED_NAME_CONTAINING_ELECTRIC)
  private Boolean containingElectric = false;

  public static final String SERIALIZED_NAME_DANGEROUS_GOODS = "dangerousGoods";
  @SerializedName(SERIALIZED_NAME_DANGEROUS_GOODS)
  private Boolean dangerousGoods = false;

  public static final String SERIALIZED_NAME_NEEDS_PACKAGING = "needsPackaging";
  @SerializedName(SERIALIZED_NAME_NEEDS_PACKAGING)
  private Boolean needsPackaging = true;

  public static final String SERIALIZED_NAME_MULTI_ITEM_INDEPENDENT_PACKAGING = "multiItemIndependentPackaging";
  @SerializedName(SERIALIZED_NAME_MULTI_ITEM_INDEPENDENT_PACKAGING)
  private Boolean multiItemIndependentPackaging = false;

  public static final String SERIALIZED_NAME_PACKAGING_MATERIAL = "packagingMaterial";
  @SerializedName(SERIALIZED_NAME_PACKAGING_MATERIAL)
  private Boolean packagingMaterial = false;

  public static final String SERIALIZED_NAME_SERIAL_NUMBER_MANAGEMENT = "serialNumberManagement";
  @SerializedName(SERIALIZED_NAME_SERIAL_NUMBER_MANAGEMENT)
  private Boolean serialNumberManagement = false;

  public Attributes() {
  }

  public Attributes containingElectric(Boolean containingElectric) {
    this.containingElectric = containingElectric;
    return this;
  }

   /**
   * 是否含有电子元件。
   * @return containingElectric
  **/
  @javax.annotation.Nullable

  public Boolean getContainingElectric() {
    return containingElectric;
  }

  public void setContainingElectric(Boolean containingElectric) {
    this.containingElectric = containingElectric;
  }


  public Attributes dangerousGoods(Boolean dangerousGoods) {
    this.dangerousGoods = dangerousGoods;
    return this;
  }

   /**
   * 是否危险品。
   * @return dangerousGoods
  **/
  @javax.annotation.Nullable

  public Boolean getDangerousGoods() {
    return dangerousGoods;
  }

  public void setDangerousGoods(Boolean dangerousGoods) {
    this.dangerousGoods = dangerousGoods;
  }


  public Attributes needsPackaging(Boolean needsPackaging) {
    this.needsPackaging = needsPackaging;
    return this;
  }

   /**
   * 是否需要包装。
   * @return needsPackaging
  **/
  @javax.annotation.Nullable

  public Boolean getNeedsPackaging() {
    return needsPackaging;
  }

  public void setNeedsPackaging(Boolean needsPackaging) {
    this.needsPackaging = needsPackaging;
  }


  public Attributes multiItemIndependentPackaging(Boolean multiItemIndependentPackaging) {
    this.multiItemIndependentPackaging = multiItemIndependentPackaging;
    return this;
  }

   /**
   * 多件独立包装。
   * @return multiItemIndependentPackaging
  **/
  @javax.annotation.Nullable

  public Boolean getMultiItemIndependentPackaging() {
    return multiItemIndependentPackaging;
  }

  public void setMultiItemIndependentPackaging(Boolean multiItemIndependentPackaging) {
    this.multiItemIndependentPackaging = multiItemIndependentPackaging;
  }


  public Attributes packagingMaterial(Boolean packagingMaterial) {
    this.packagingMaterial = packagingMaterial;
    return this;
  }

   /**
   * 是否包材。
   * @return packagingMaterial
  **/
  @javax.annotation.Nullable

  public Boolean getPackagingMaterial() {
    return packagingMaterial;
  }

  public void setPackagingMaterial(Boolean packagingMaterial) {
    this.packagingMaterial = packagingMaterial;
  }


  public Attributes serialNumberManagement(Boolean serialNumberManagement) {
    this.serialNumberManagement = serialNumberManagement;
    return this;
  }

   /**
   * 是否序列号管理。
   * @return serialNumberManagement
  **/
  @javax.annotation.Nullable

  public Boolean getSerialNumberManagement() {
    return serialNumberManagement;
  }

  public void setSerialNumberManagement(Boolean serialNumberManagement) {
    this.serialNumberManagement = serialNumberManagement;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attributes attributes = (Attributes) o;
    return Objects.equals(this.containingElectric, attributes.containingElectric) &&
        Objects.equals(this.dangerousGoods, attributes.dangerousGoods) &&
        Objects.equals(this.needsPackaging, attributes.needsPackaging) &&
        Objects.equals(this.multiItemIndependentPackaging, attributes.multiItemIndependentPackaging) &&
        Objects.equals(this.packagingMaterial, attributes.packagingMaterial) &&
        Objects.equals(this.serialNumberManagement, attributes.serialNumberManagement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containingElectric, dangerousGoods, needsPackaging, multiItemIndependentPackaging, packagingMaterial, serialNumberManagement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attributes {\n");
    sb.append("    containingElectric: ").append(toIndentedString(containingElectric)).append("\n");
    sb.append("    dangerousGoods: ").append(toIndentedString(dangerousGoods)).append("\n");
    sb.append("    needsPackaging: ").append(toIndentedString(needsPackaging)).append("\n");
    sb.append("    multiItemIndependentPackaging: ").append(toIndentedString(multiItemIndependentPackaging)).append("\n");
    sb.append("    packagingMaterial: ").append(toIndentedString(packagingMaterial)).append("\n");
    sb.append("    serialNumberManagement: ").append(toIndentedString(serialNumberManagement)).append("\n");
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
    openapiFields.add("containingElectric");
    openapiFields.add("dangerousGoods");
    openapiFields.add("needsPackaging");
    openapiFields.add("multiItemIndependentPackaging");
    openapiFields.add("packagingMaterial");
    openapiFields.add("serialNumberManagement");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Attributes
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Attributes.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Attributes is not found in the empty JSON string", Attributes.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Attributes.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Attributes` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Attributes.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Attributes' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Attributes> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Attributes.class));

       return (TypeAdapter<T>) new TypeAdapter<Attributes>() {
           @Override
           public void write(JsonWriter out, Attributes value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Attributes read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Attributes given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Attributes
  * @throws IOException if the JSON string is invalid with respect to Attributes
  */
  public static Attributes fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Attributes.class);
  }

 /**
  * Convert an instance of Attributes to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

