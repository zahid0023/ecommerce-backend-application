-- Root category
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (1, NULL, 'Fashion', 'All fashion products');

-- Men
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (2, 1, 'Men', 'Men fashion');

-- Men -> Clothing
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (3, 2, 'Clothing', 'Men clothing');

-- Men -> Clothing -> Tops, Bottoms, Outerwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (4, 3, 'Tops', 'Men tops'),
       (5, 3, 'Bottoms', 'Men bottoms'),
       (6, 3, 'Outerwear', 'Men outerwear');

-- Men -> Clothing -> Tops -> Items
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (7, 4, 'T-Shirts', 'Men T-Shirts'),
       (8, 4, 'Shirts', 'Men Shirts'),
       (9, 4, 'Sweaters', 'Men Sweaters'),
       (10, 4, 'Polos', 'Men Polos'),
       (11, 4, 'Hoodies & Sweatshirts', 'Men Hoodies and Sweatshirts');

-- Men -> Clothing -> Bottoms -> Items
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (12, 5, 'Jeans', 'Men Jeans'),
       (13, 5, 'Chinos', 'Men Chinos'),
       (14, 5, 'Shorts', 'Men Shorts'),
       (15, 5, 'Joggers', 'Men Joggers');

-- Men -> Clothing -> Outerwear -> Items
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (16, 6, 'Jackets', 'Men Jackets'),
       (17, 6, 'Hoodies', 'Men Hoodies'),
       (18, 6, 'Coats', 'Men Coats'),
       (19, 6, 'Blazers', 'Men Blazers'),
       (20, 6, 'Vests', 'Men Vests');

-- Men -> Footwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (21, 2, 'Footwear', 'Men Footwear');

INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (22, 21, 'Sneakers', 'Men Sneakers'),
       (23, 21, 'Formal Shoes', 'Men Formal Shoes'),
       (24, 21, 'Sandals', 'Men Sandals'),
       (25, 21, 'Boots', 'Men Boots');

-- Men -> Accessories
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (26, 2, 'Accessories', 'Men Accessories');

INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (27, 26, 'Belts', 'Men Belts'),
       (28, 26, 'Hats & Caps', 'Men Hats and Caps'),
       (29, 26, 'Sunglasses', 'Men Sunglasses'),
       (30, 26, 'Watches', 'Men Watches'),
       (31, 26, 'Wallets', 'Men Wallets'),
       (32, 26, 'Ties & Bowties', 'Men Ties and Bowties');

-- Women
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (33, 1, 'Women', 'Women fashion');

-- Women -> Clothing, Outerwear, Footwear, Accessories
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (34, 33, 'Clothing', 'Women Clothing'),
       (35, 33, 'Outerwear', 'Women Outerwear'),
       (36, 33, 'Footwear', 'Women Footwear'),
       (37, 33, 'Accessories', 'Women Accessories');

-- Women -> Clothing -> Tops
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (38, 34, 'Tops', 'Women Tops'),
       (39, 38, 'T-Shirts', 'Women T-Shirts'),
       (40, 38, 'Blouses', 'Women Blouses'),
       (41, 38, 'Sweaters', 'Women Sweaters'),
       (42, 38, 'Tunics', 'Women Tunics'),
       (43, 38, 'Hoodies & Sweatshirts', 'Women Hoodies & Sweatshirts');

-- Women -> Clothing -> Bottoms
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (44, 34, 'Bottoms', 'Women Bottoms'),
       (45, 44, 'Jeans', 'Women Jeans'),
       (46, 44, 'Skirts', 'Women Skirts'),
       (47, 44, 'Trousers', 'Women Trousers'),
       (48, 44, 'Shorts', 'Women Shorts');

-- Women -> Clothing -> Dresses
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (49, 34, 'Dresses', 'Women Dresses'),
       (50, 49, 'Casual Dresses', 'Casual Dresses'),
       (51, 49, 'Party Dresses', 'Party Dresses'),
       (52, 49, 'Maxi Dresses', 'Maxi Dresses'),
       (53, 49, 'Evening Gowns', 'Evening Gowns'),
       (54, 49, 'Cocktail Dresses', 'Cocktail Dresses');

-- Women -> Outerwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (55, 35, 'Jackets', 'Women Jackets'),
       (56, 35, 'Coats', 'Women Coats'),
       (57, 35, 'Blazers', 'Women Blazers'),
       (58, 35, 'Cardigans', 'Women Cardigans');

-- Women -> Footwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (59, 36, 'Heels', 'Women Heels'),
       (60, 36, 'Flats', 'Women Flats'),
       (61, 36, 'Sneakers', 'Women Sneakers'),
       (62, 36, 'Boots', 'Women Boots');

-- Women -> Accessories
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (63, 37, 'Bags & Purses', 'Bags and Purses'),
       (64, 37, 'Jewelry', 'Women Jewelry'),
       (65, 37, 'Scarves', 'Women Scarves'),
       (66, 37, 'Sunglasses', 'Women Sunglasses'),
       (67, 37, 'Hats & Caps', 'Women Hats & Caps'),
       (68, 37, 'Belts', 'Women Belts');

-- Children
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (69, 1, 'Children', 'Children Fashion');

-- Children -> Boys
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (70, 69, 'Boys', 'Boys Clothing'),
       (71, 70, 'Tops', 'Boys Tops'),
       (72, 70, 'Bottoms', 'Boys Bottoms'),
       (73, 70, 'Outerwear', 'Boys Outerwear'),
       (74, 70, 'Footwear', 'Boys Footwear');

-- Boys -> Tops
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (75, 71, 'T-Shirts', 'Boys T-Shirts'),
       (76, 71, 'Shirts', 'Boys Shirts'),
       (77, 71, 'Sweaters', 'Boys Sweaters'),
       (78, 71, 'Hoodies', 'Boys Hoodies');

-- Boys -> Bottoms
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (79, 72, 'Jeans', 'Boys Jeans'),
       (80, 72, 'Shorts', 'Boys Shorts'),
       (81, 72, 'Joggers', 'Boys Joggers');

-- Boys -> Outerwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (82, 73, 'Jackets', 'Boys Jackets'),
       (83, 73, 'Coats', 'Boys Coats');

-- Boys -> Footwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (84, 74, 'Sneakers', 'Boys Sneakers'),
       (85, 74, 'Sandals', 'Boys Sandals'),
       (86, 74, 'Boots', 'Boys Boots');

-- Children -> Girls
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (87, 69, 'Girls', 'Girls Clothing'),
       (88, 87, 'Tops', 'Girls Tops'),
       (89, 87, 'Bottoms', 'Girls Bottoms'),
       (90, 87, 'Dresses', 'Girls Dresses'),
       (91, 87, 'Outerwear', 'Girls Outerwear'),
       (92, 87, 'Footwear', 'Girls Footwear');

-- Girls -> Tops
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (93, 88, 'T-Shirts', 'Girls T-Shirts'),
       (94, 88, 'Blouses', 'Girls Blouses'),
       (95, 88, 'Sweaters', 'Girls Sweaters'),
       (96, 88, 'Tunics', 'Girls Tunics');

-- Girls -> Bottoms
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (97, 89, 'Skirts', 'Girls Skirts'),
       (98, 89, 'Jeans', 'Girls Jeans'),
       (99, 89, 'Leggings', 'Girls Leggings'),
       (100, 89, 'Shorts', 'Girls Shorts');

-- Girls -> Dresses
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (101, 90, 'Casual Dresses', 'Casual Dresses'),
       (102, 90, 'Party Dresses', 'Party Dresses'),
       (103, 90, 'Summer Dresses', 'Summer Dresses'),
       (104, 90, 'School Uniforms', 'School Uniforms');

-- Girls -> Outerwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (105, 91, 'Jackets', 'Girls Jackets'),
       (106, 91, 'Coats', 'Girls Coats'),
       (107, 91, 'Cardigans', 'Girls Cardigans');

-- Girls -> Footwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (108, 92, 'Flats', 'Girls Flats'),
       (109, 92, 'Sneakers', 'Girls Sneakers'),
       (110, 92, 'Sandals', 'Girls Sandals'),
       (111, 92, 'Boots', 'Girls Boots');

-- Children -> Baby (0–24 months)
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (112, 69, 'Baby (0–24 months)', 'Baby Clothing'),
       (113, 112, 'Clothing', 'Baby Clothing'),
       (114, 112, 'Outerwear', 'Baby Outerwear'),
       (115, 112, 'Footwear', 'Baby Footwear');

-- Baby -> Clothing
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (116, 113, 'Rompers', 'Baby Rompers'),
       (117, 113, 'Bodysuits', 'Baby Bodysuits'),
       (118, 113, 'Sleepsuits', 'Baby Sleepsuits'),
       (119, 113, 'Onesies', 'Baby Onesies');

-- Baby -> Outerwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (120, 114, 'Jackets', 'Baby Jackets'),
       (121, 114, 'Sweaters', 'Baby Sweaters');

-- Baby -> Footwear
INSERT INTO platform_categories (id, parent_id, name, description)
VALUES (122, 115, 'Soft Shoes', 'Baby Soft Shoes'),
       (123, 115, 'Booties', 'Baby Booties');
