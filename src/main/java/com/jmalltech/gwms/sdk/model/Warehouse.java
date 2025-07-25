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
import com.jmalltech.gwms.sdk.model.Address;
import com.jmalltech.gwms.sdk.model.ContactInfo;
import com.jmalltech.gwms.sdk.model.Currency;
import com.jmalltech.gwms.sdk.model.EntityStatus;
import java.io.IOException;
import java.time.OffsetDateTime;
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
 * Warehouse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Warehouse implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_CREATE_BY = "createBy";
  @SerializedName(SERIALIZED_NAME_CREATE_BY)
  private Long createBy;

  public static final String SERIALIZED_NAME_CREATE_TIME = "createTime";
  @SerializedName(SERIALIZED_NAME_CREATE_TIME)
  private OffsetDateTime createTime;

  public static final String SERIALIZED_NAME_UPDATE_BY = "updateBy";
  @SerializedName(SERIALIZED_NAME_UPDATE_BY)
  private Long updateBy;

  public static final String SERIALIZED_NAME_UPDATE_TIME = "updateTime";
  @SerializedName(SERIALIZED_NAME_UPDATE_TIME)
  private OffsetDateTime updateTime;

  public static final String SERIALIZED_NAME_PARAMS = "params";
  @SerializedName(SERIALIZED_NAME_PARAMS)
  private Map<String, Object> params = new HashMap<>();

  public static final String SERIALIZED_NAME_WAREHOUSE_ID = "warehouseId";
  @SerializedName(SERIALIZED_NAME_WAREHOUSE_ID)
  private Long warehouseId;

  public static final String SERIALIZED_NAME_CODE = "code";
  @SerializedName(SERIALIZED_NAME_CODE)
  private String code;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_ADDRESS = "address";
  @SerializedName(SERIALIZED_NAME_ADDRESS)
  private Address address;

  public static final String SERIALIZED_NAME_CONTACT_INFO = "contactInfo";
  @SerializedName(SERIALIZED_NAME_CONTACT_INFO)
  private ContactInfo contactInfo;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private Currency currency;

  public static final String SERIALIZED_NAME_ENTERPRISE = "enterprise";
  @SerializedName(SERIALIZED_NAME_ENTERPRISE)
  private String enterprise;

  public static final String SERIALIZED_NAME_RECIPIENT = "recipient";
  @SerializedName(SERIALIZED_NAME_RECIPIENT)
  private String recipient;

  public static final String SERIALIZED_NAME_SORT = "sort";
  @SerializedName(SERIALIZED_NAME_SORT)
  private Long sort;

  public static final String SERIALIZED_NAME_REMARK = "remark";
  @SerializedName(SERIALIZED_NAME_REMARK)
  private String remark;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private EntityStatus status;

  public Warehouse() {
  }

  public Warehouse createBy(Long createBy) {
    this.createBy = createBy;
    return this;
  }

   /**
   * 创建者ID
   * @return createBy
  **/
  @javax.annotation.Nullable

  public Long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Long createBy) {
    this.createBy = createBy;
  }


  public Warehouse createTime(OffsetDateTime createTime) {
    this.createTime = createTime;
    return this;
  }

   /**
   * 创建时间
   * @return createTime
  **/
  @javax.annotation.Nullable
  @Valid

  public OffsetDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(OffsetDateTime createTime) {
    this.createTime = createTime;
  }


  public Warehouse updateBy(Long updateBy) {
    this.updateBy = updateBy;
    return this;
  }

   /**
   * 更新者ID
   * @return updateBy
  **/
  @javax.annotation.Nullable

  public Long getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(Long updateBy) {
    this.updateBy = updateBy;
  }


  public Warehouse updateTime(OffsetDateTime updateTime) {
    this.updateTime = updateTime;
    return this;
  }

   /**
   * 更新时间
   * @return updateTime
  **/
  @javax.annotation.Nullable
  @Valid

  public OffsetDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(OffsetDateTime updateTime) {
    this.updateTime = updateTime;
  }


  public Warehouse params(Map<String, Object> params) {
    this.params = params;
    return this;
  }

  public Warehouse putParamsItem(String key, Object paramsItem) {
    if (this.params == null) {
      this.params = new HashMap<>();
    }
    this.params.put(key, paramsItem);
    return this;
  }

   /**
   * 扩展参数
   * @return params
  **/
  @javax.annotation.Nullable

  public Map<String, Object> getParams() {
    return params;
  }

  public void setParams(Map<String, Object> params) {
    this.params = params;
  }


  public Warehouse warehouseId(Long warehouseId) {
    this.warehouseId = warehouseId;
    return this;
  }

   /**
   * 仓库唯一标识
   * @return warehouseId
  **/
  @javax.annotation.Nonnull
  @NotNull

  public Long getWarehouseId() {
    return warehouseId;
  }

  public void setWarehouseId(Long warehouseId) {
    this.warehouseId = warehouseId;
  }


  public Warehouse code(String code) {
    this.code = code;
    return this;
  }

   /**
   * 仓库编码
   * @return code
  **/
  @javax.annotation.Nonnull
  @NotNull
 @Pattern(regexp="^[A-Z0-9-]{1,20}$") @Size(min=1,max=20)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public Warehouse name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 仓库名称
   * @return name
  **/
  @javax.annotation.Nonnull
  @NotNull
 @Size(min=1,max=40)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Warehouse address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  public Warehouse contactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
    return this;
  }

   /**
   * Get contactInfo
   * @return contactInfo
  **/
  @javax.annotation.Nullable
  @Valid

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }


  public Warehouse currency(Currency currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @javax.annotation.Nullable
  @Valid

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }


  public Warehouse enterprise(String enterprise) {
    this.enterprise = enterprise;
    return this;
  }

   /**
   * 公司
   * @return enterprise
  **/
  @javax.annotation.Nullable
 @Size(max=50)
  public String getEnterprise() {
    return enterprise;
  }

  public void setEnterprise(String enterprise) {
    this.enterprise = enterprise;
  }


  public Warehouse recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

   /**
   * 收件人
   * @return recipient
  **/
  @javax.annotation.Nullable
 @Size(min=1,max=64)
  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }


  public Warehouse sort(Long sort) {
    this.sort = sort;
    return this;
  }

   /**
   * 排序
   * minimum: 0
   * maximum: 9999
   * @return sort
  **/
  @javax.annotation.Nullable
 @Min(0L) @Max(9999L)
  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }


  public Warehouse remark(String remark) {
    this.remark = remark;
    return this;
  }

   /**
   * 备注
   * @return remark
  **/
  @javax.annotation.Nullable
 @Size(max=500)
  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public Warehouse status(EntityStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  @NotNull
  @Valid

  public EntityStatus getStatus() {
    return status;
  }

  public void setStatus(EntityStatus status) {
    this.status = status;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Warehouse warehouse = (Warehouse) o;
    return Objects.equals(this.createBy, warehouse.createBy) &&
        Objects.equals(this.createTime, warehouse.createTime) &&
        Objects.equals(this.updateBy, warehouse.updateBy) &&
        Objects.equals(this.updateTime, warehouse.updateTime) &&
        Objects.equals(this.params, warehouse.params) &&
        Objects.equals(this.warehouseId, warehouse.warehouseId) &&
        Objects.equals(this.code, warehouse.code) &&
        Objects.equals(this.name, warehouse.name) &&
        Objects.equals(this.address, warehouse.address) &&
        Objects.equals(this.contactInfo, warehouse.contactInfo) &&
        Objects.equals(this.currency, warehouse.currency) &&
        Objects.equals(this.enterprise, warehouse.enterprise) &&
        Objects.equals(this.recipient, warehouse.recipient) &&
        Objects.equals(this.sort, warehouse.sort) &&
        Objects.equals(this.remark, warehouse.remark) &&
        Objects.equals(this.status, warehouse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createBy, createTime, updateBy, updateTime, params, warehouseId, code, name, address, contactInfo, currency, enterprise, recipient, sort, remark, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Warehouse {\n");
    sb.append("    createBy: ").append(toIndentedString(createBy)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateBy: ").append(toIndentedString(updateBy)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    warehouseId: ").append(toIndentedString(warehouseId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    contactInfo: ").append(toIndentedString(contactInfo)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    enterprise: ").append(toIndentedString(enterprise)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
    openapiFields.add("createBy");
    openapiFields.add("createTime");
    openapiFields.add("updateBy");
    openapiFields.add("updateTime");
    openapiFields.add("params");
    openapiFields.add("warehouseId");
    openapiFields.add("code");
    openapiFields.add("name");
    openapiFields.add("address");
    openapiFields.add("contactInfo");
    openapiFields.add("currency");
    openapiFields.add("enterprise");
    openapiFields.add("recipient");
    openapiFields.add("sort");
    openapiFields.add("remark");
    openapiFields.add("status");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("warehouseId");
    openapiRequiredFields.add("code");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("status");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Warehouse
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Warehouse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Warehouse is not found in the empty JSON string", Warehouse.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Warehouse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Warehouse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Warehouse.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("code").toString()));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      // validate the optional field `address`
      if (jsonObj.get("address") != null && !jsonObj.get("address").isJsonNull()) {
        Address.validateJsonElement(jsonObj.get("address"));
      }
      // validate the optional field `contactInfo`
      if (jsonObj.get("contactInfo") != null && !jsonObj.get("contactInfo").isJsonNull()) {
        ContactInfo.validateJsonElement(jsonObj.get("contactInfo"));
      }
      // validate the optional field `currency`
      if (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) {
        Currency.validateJsonElement(jsonObj.get("currency"));
      }
      if ((jsonObj.get("enterprise") != null && !jsonObj.get("enterprise").isJsonNull()) && !jsonObj.get("enterprise").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `enterprise` to be a primitive type in the JSON string but got `%s`", jsonObj.get("enterprise").toString()));
      }
      if ((jsonObj.get("recipient") != null && !jsonObj.get("recipient").isJsonNull()) && !jsonObj.get("recipient").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `recipient` to be a primitive type in the JSON string but got `%s`", jsonObj.get("recipient").toString()));
      }
      if ((jsonObj.get("remark") != null && !jsonObj.get("remark").isJsonNull()) && !jsonObj.get("remark").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `remark` to be a primitive type in the JSON string but got `%s`", jsonObj.get("remark").toString()));
      }
      // validate the required field `status`
      EntityStatus.validateJsonElement(jsonObj.get("status"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Warehouse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Warehouse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Warehouse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Warehouse.class));

       return (TypeAdapter<T>) new TypeAdapter<Warehouse>() {
           @Override
           public void write(JsonWriter out, Warehouse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Warehouse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Warehouse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Warehouse
  * @throws IOException if the JSON string is invalid with respect to Warehouse
  */
  public static Warehouse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Warehouse.class);
  }

 /**
  * Convert an instance of Warehouse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

