Owner will create an user account. Then create a shop. then populate the pages for the shop with predefined components.

| Step | Entity           | Description                                                                             |
|------|------------------|-----------------------------------------------------------------------------------------|
| 1    | `owner`          | Owner registers                                                                         |
| 2    | `shop`           | Owner creates a shop                                                                    |
| 3    | `shop_page`      | Each shop has a set of pages (Home, Products, etc.)                                     |
| 4    | `shop_component` | Each page is built by selecting predefined components from the system `component` table |
| 5    | `custom_config`  | Allows the owner to change settings like colors, text, or layout for their own shop     |

| Layer                             | Scope                  | Tables                                     | Purpose                                                                              |
|-----------------------------------|------------------------|--------------------------------------------|--------------------------------------------------------------------------------------|
| 🧩 **System Level (predefined)**  | Global, created by you | `page_type`, `component_type`, `component` | Define what exists (page types, component types, and predefined component templates) |
| 🏪 **Shop Level (user-specific)** | Per user/shop          | `shop`, `shop_page`, `shop_component`      | Define how each shop uses those components                                           |

