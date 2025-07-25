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


package com.jmalltech.gwms.sdk.api;

import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.model.ApiErrorResponse;
import com.jmalltech.gwms.sdk.model.ProductBatchRequest;
import com.jmalltech.gwms.sdk.model.ProductBatchResponse;
import com.jmalltech.gwms.sdk.model.ProductCreateRequest;
import com.jmalltech.gwms.sdk.model.ProductListResponse;
import com.jmalltech.gwms.sdk.model.ProductPartialUpdateRequest;
import com.jmalltech.gwms.sdk.model.ProductResponse;
import com.jmalltech.gwms.sdk.model.ProductStatus;
import com.jmalltech.gwms.sdk.model.ProductUpdateRequest;
import com.jmalltech.gwms.sdk.model.SortDirection;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProductsApi
 */
@Disabled
public class ProductsApiTest {

    private final ProductsApi api = new ProductsApi();

    /**
     * 创建一个产品
     *
     * 在主数据中创建一个新产品。此操作是幂等的，支持上游系统推送产品数据。
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createProductTest() throws ApiException {
        UUID idempotencyKey = null;
        ProductCreateRequest productCreateRequest = null;
        ProductResponse response = api.createProduct(idempotencyKey, productCreateRequest);
        // TODO: test validations
    }

    /**
     * 批量创建产品
     *
     * 支持上游系统批量推送产品数据到WMS系统。适用于ERP系统、电商平台等批量同步产品主数据的场景。批量操作具有事务一致性：要么全部成功创建，要么全部失败。
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createProductsBatchTest() throws ApiException {
        UUID idempotencyKey = null;
        ProductBatchRequest productBatchRequest = null;
        ProductBatchResponse response = api.createProductsBatch(idempotencyKey, productBatchRequest);
        // TODO: test validations
    }

    /**
     * 通过SKU编码删除产品
     *
     * 通过产品SKU编码删除产品。外部skuCode将映射到内部的sku或gsku字段。
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteProductBySkuCodeTest() throws ApiException {
        String skuCode = null;
        api.deleteProductBySkuCode(skuCode);
        // TODO: test validations
    }

    /**
     * 通过SKU编码获取产品
     *
     * 通过产品SKU编码检索特定产品的详细信息。外部skuCode将映射到内部的sku或gsku字段。
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getProductBySkuCodeTest() throws ApiException {
        String skuCode = null;
        ProductResponse response = api.getProductBySkuCode(skuCode);
        // TODO: test validations
    }

    /**
     * 列出产品
     *
     * 检索产品的分页列表，允许过滤和排序。
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listProductsTest() throws ApiException {
        Integer pageNumber = null;
        Integer pageSize = null;
        String sort = null;
        SortDirection isAsc = null;
        String sku = null;
        ProductStatus status = null;
        ProductListResponse response = api.listProducts(pageNumber, pageSize, sort, isAsc, sku, status);
        // TODO: test validations
    }

    /**
     * 通过SKU编码更新产品（部分）
     *
     * 通过产品SKU编码更新产品的一个或多个属性。外部skuCode将映射到内部的sku或gsku字段。
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void partialUpdateProductBySkuCodeTest() throws ApiException {
        String skuCode = null;
        ProductPartialUpdateRequest productPartialUpdateRequest = null;
        ProductResponse response = api.partialUpdateProductBySkuCode(skuCode, productPartialUpdateRequest);
        // TODO: test validations
    }

    /**
     * 通过SKU编码更新产品（完整）
     *
     * 通过产品SKU编码更新产品的所有属性。外部skuCode将映射到内部的sku或gsku字段。
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateProductBySkuCodeTest() throws ApiException {
        String skuCode = null;
        ProductUpdateRequest productUpdateRequest = null;
        ProductResponse response = api.updateProductBySkuCode(skuCode, productUpdateRequest);
        // TODO: test validations
    }

}
