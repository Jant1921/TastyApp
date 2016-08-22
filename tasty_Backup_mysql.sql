CREATE DATABASE tastyapp /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE recipe (
  RecipeId int(11) NOT NULL AUTO_INCREMENT,
  recipe_title varchar(300) DEFAULT NULL,
  recipe_image varchar(400) DEFAULT NULL,
  recipe_description varchar(100) DEFAULT NULL,
  recipe_ingredients varchar(2000) DEFAULT NULL,
  recipe_preparation varchar(2000) DEFAULT NULL,
  recipe_video varchar(45) DEFAULT NULL,
  recipe_category varchar(50) DEFAULT NULL,
  PRIMARY KEY (RecipeId)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `tastyapp`.`recipe`
(`RecipeId`,
`recipe_title`,
`recipe_image`,
`recipe_description`,
`recipe_ingredients`,
`recipe_preparation`,
`recipe_video`,
`recipe_category`)
VALUES
(1,"Pink Grapefruit Margaritas","https://img.buzzfeed.com/buzzfeed-static/static/2016-03/25/12/enhanced/webdr12/enhanced-10446-1458923886-9.jpg?no-auto","We cooked up a delicious and super refreshing freshly-squeezed pink grapefruit marg","1/4 cup simple syrup (recipe follows):
 1/4 cup sugar
 1/4 cup water
 8 ruby red grapefruits
 6 oz silver tequila
 Sugar","In a saucepan, bring the 1/4 cup sugar and 1/4 cup water to a boil. Wait until they’re completely combined, then set aside to cool. Squeeze the juice out of all the grapefruits, and combine with the tequila and the simple syrup you just made. Wet the rim of your glasses (you can do this with a slice of grapefruit), and dip in sugar. Serve over ice!","4pUOmj5hknE","Happy"
),
(2,"Sparkling Strawberry Kiwi Sangria","https://img.buzzfeed.com/buzzfeed-static/static/2016-03/4/16/enhanced/webdr14/enhanced-22493-1457128135-8.jpg?no-auto","Kick back with this sparkling strawberry kiwi sangria and enjoy!","1 lb strawberries
 1 lb kiwis
 1 cup light rum
 1 bottle white wine (such as sauvignon blanc)
 1 bottle sparkling wine, chilled (such as cava)
 1 cup sugar
 1 cup water
 3 oranges
 A pitcher or other large container","Combine half of the halved strawberries, the sugar, and the water in a saucepan, and turn the heat up to medium. Bring the mixture to a boil and then let simmer, stirring occasionally, for 10 minutes or until the strawberries seem like they’re about to fall apart. Let cool for a few minutes, and then, using a mesh sieve, strain the strawberry goodness into a bowl. Use a spoon to press the strawberries up against the mesh so you get every last beautiful drop of strawberry syrup. Place the syrup in the refrigerator to cool a bit.
Combine the kiwi slices and the remaining strawberries in a pitcher, and add the rum, white wine, strawberry syrup, and the juice of three oranges (in a pinch, you could also sub a few splashes of bottled orange juice, or even lemonade, for the fresh orange juice). Give it all a good stir and then pop the pitcher in the refrigerator for at least four hours to let all of the flavors come together. 
When you’re ready to serve, add around three-quarters of the chilled sparkling wine to the pitcher. Pour into glasses and spoon in fruit, topping off each glass with a bit of the remaining champagne so it’s nice and bubbly when you hand the glass to a friend.","AQKn5rRMjx8","Happy"
),(3,"Roast Leg of Lamb","https://img.buzzfeed.com/buzzfeed-static/static/2016-03/24/13/enhanced/webdr05/enhanced-8748-1458840620-11.jpg?no-auto","This lamb is totally the perfect cut of meat for your Easter brunch, so get into it!","6 Tbsp. of olive oil
1/4 cup of rosemary
6 cloves of garlic
3 shallots
1/2 Tbsp. of thyme
2 tsp of pepper
3 1/2 tsp of salt
5 lb leg of lamb, boneless
Carrots
Potatoes
Onions
Garlic cloves
Salt and pepper
Olive oil","Create the herb rub in a food processor. Pulse the olive oil, rosemary, garlic, shallots, thyme, pepper and salt together until you have a thick paste. Spread out the leg of lamb and rub half of the herb rub all over the exposed side of the lamb. Roll up and securely tie the leg of lamb together with kitchen twine.
In the roasting pan, spread out the carrots, potatoes, onions, and garlic cloves. Rest the leg of lamb on top of the vegetables. Pour the rest of the herb rub all over the leg of lamb, spread out so it coats evenly. Roast at 450°F/230°C for 50 - 60 minutes or until the internal temperature reads 130°F to 135°F for medium rare.
Remove the leg of lamb and let it rest of 20 minutes before you remove the kitchen twine and before you carve.
Serve with the roasted vegetables. Enjoy!","1NmzTHxsCWY","Comfort"
),(
4,"Cheese-Stuffed Chicken Nuggets","https://img.buzzfeed.com/buzzfeed-static/static/2016-02/19/19/enhanced/webdr09/enhanced-8228-1455928222-6.jpg?no-auto","Stop Whatever You’re Doing And Make These Cheese-Stuffed Chicken Nuggets","Ground chicken
Salt and pepper
Cubed cheese (We used mozzarella, but you can use whatever you want)
Panko
Oregano
Flour
Eggs 
Oil for frying
Condiments of your choice","First, season the ground chicken with salt and pepper. Grab a handful of ground chicken and roll into a rough ball shape, place a cube of cheese in the center and wrap the ground chicken around it. Form it into a chicken nugget shape. Set aside.
Season the panko with oregano. Take the chicken nuggets and coat with flour, dip in egg and cover with the panko/oregano mix. Deep fry in the oil until browned and crispy.","A1XJ8guc5vs","Comfort"
),(
5,"Pretzel Bites","https://img.buzzfeed.com/buzzfeed-static/static/2016-02/8/17/enhanced/webdr09/enhanced-5036-1454971498-1.jpg?no-auto","These pretzel bites will be a sure fire hit at your next party, that’s all!","3 cups shredded cheddar cheese
2 Tbsp. corn starch
1/2 cup + 2 Tbsp. beer of your choice
1 lb of pizza dough
5 cups water
1/4 cup baking soda
1 egg
Coarse salt","Toss the cheddar cheese with the corn starch until it’s evenly distributed. In a medium saucepan, bring 1/2 cup of beer to a simmer. Then add in the cheese and corn starch mixture and whisk until it begins to thicken. Once thick, take off the heat. (It may cool and become more solid over time, but don’t worry! It will melt back down in the oven, so this is fine.)
Slice a small piece of your pizza dough, roll it into a ball, then flatten it out. Place a small spoonful of the beer cheese mixture in the center of the dough. Pick up the top and bottom edges and bring them up and together. Do the same with the left and right edges. Continue bringing in the rest of the edges of the dough until it all meets in the center and there are no gaps for the cheese to leak out of during baking. (You can pick up and twist the top of the dough to make sure everything is more secure.)
Bring five cups of water to a boil in a medium pot. When you’ve finished putting together your pretzel bites, add the baking soda to the water and immediately scoop in your pretzel bites. Boil for 20-30 seconds, then take out and place on a baking sheet lined with parchment paper. In a small bowl, combine one egg and two tablespoons of beer and beat with a fork until they are well blended. Brush the mixture onto the top of each pretzel bite, then top with coarse salt.
Bake for 15-20 minutes (or until they have browned).","Ilg-VHygc_s","Comfort"
),(
6,"Easy Pizza","https://img.buzzfeed.com/buzzfeed-static/static/2016-03/1/12/enhanced/webdr03/enhanced-15148-1456853692-1.jpg?no-auto","Totally something you can do with your little one at home, too!","1 cup warm water
2 tsp sugar
1 packet active yeast
2½ cups bread flour
1 tsp salt
1 Tbsp. olive oil
1 jar marinara sauce
Mozzarella cheese
Additional toppings of choice","Preheat oven to 450°F / 230°C.
In a large bowl, combine 1 cup warm water, 2 teaspoons of sugar, and 1 packet active yeast. Stir and then let sit for 10 minutes to allow yeast to activate.
Add 2½ cups bread flour, 1 teaspoon of salt, and 1 tablespoon of olive oil. Mix until it forms an even ball of dough.
Cut into as many pieces as desired and flatten into pizza crust shape. Top with desired toppings and bake at 450°F/230°C for 10 to 15 minutes or until crust is golden brown.","PG6oAO9sgEU","Pizza"
),(
7,"Root Beer Pie","https://img.buzzfeed.com/buzzfeed-static/static/2016-03/14/15/enhanced/webdr10/enhanced-25958-1457985245-1.jpg?no-auto","A lovely root beer pie and it is just to die for!","Yields one pie.
 8 oz heavy whipping cream
 12 oz root beer
 1/4 cup milk
 1 box vanilla pudding mix
 1 graham cracker crust","Mix the root beer, milk, and pudding mix until thick. Beat the heavy cream until stiff peaks form, and fold into the pudding mixture. Pour into prepared graham cracker crust, and freeze for four hours or refrigerate overnight. Enjoy!","BOH-V57pqLI","Junior"
),(8,"Bacon Guacamole Chicken Bombs","https://img.buzzfeed.com/buzzfeed-static/static/2016-03/10/13/enhanced/webdr09/enhanced-26692-1457634227-1.jpg?no-auto","What happens when you combine three of the greatest things on earth? take a look for yourself:"," 2 ripe avocados
 ½ white onion, finely chopped
 ½ tomato, chopped
 2 Tbsp. cilantro, chopped
 ½ Tbsp. kosher salt
 2 Tbsp. freshly squeezed lime juice
 4 boneless skinless chicken breasts
 Kosher salt
 Freshly ground black pepper
 8 bacon strips
 1 Tbsp. canola oil","1. Preheat oven to 400°F.
2. Using a knife, cut around the pit of the avocado, separating the halves from each other. Remove the pit and use a spoon to scoop out the avocado. In a large bowl, combine the avocado, onion, tomato, cilantro, salt, and lime juice. Mash and stir with a fork until there are no large chunks of avocado left. 
3. Season chicken breasts with salt and pepper on all sides. Slice chicken breasts in half crosswise. Cut a slit into the center of each half to make a pocket. Take a heaping spoonful of the guacamole and pack it into the pocket. Pinch the edges of the chicken closed.
4. Wrap the chicken with two strips of bacon, making sure the ends of the bacon all end up on the same side of the chicken.
5. Heat oil in a pan over high heat. Sear the bacon-wrapped chicken for two to three minutes on each side. Remember to cook the sides of the chicken as well. Bake for 10 minutes. Serve!","3PYbQQK8Tg4","Dinners")
,(9,"Currywurst Sliders","https://img.buzzfeed.com/buzzfeed-static/static/2016-03/23/14/enhanced/webdr15/enhanced-22755-1458757681-1.jpg?no-auto","Curry on and make these delectable bite-sized burgers and enjoy!"," 1 pack of sausage (You can use: bratwurst, kielbasa, andouille, etc.)
 1 can whole tomatoes
 1 Teaspoon curry powder
 1 Teaspoon paprika powder
 1 Teaspoon mustard powder
 1 Teaspoon chili powder
 Salt and pepper
 1 diced onion
 Hawaiian rolls","Cut your sausage into slivers and brown in a pan on medium, with oil. Once cooked, set aside. Add your diced onion into the pan and brown them before adding your can of whole tomatoes, curry, paprika, mustard, and chili powder. Add salt and pepper to taste. Stew the ingredients together, mashing the whole tomatoes, and let simmer on low for 20 minutes.
Place your sausage onto your Hawaiian rolls, top with your relish and finish with a sprinkle of curry powder.
Enjoy!","t-asd_a1vUU","Apps"
)
,(10,"Kimchi Queso","https://img.buzzfeed.com/buzzfeed-static/static/2016-02/1/21/enhanced/webdr09/enhanced-8734-1454378645-7.jpg?no-auto","Make This Tasty Kimchi Queso And Slay Your Life"," 11/2 cups chopped Kimchi
 2-3 TBSP Korean Red Pepper Powder (depending on how spicy you want it)
 5 cups shredded cheddar cheese
 1 cup sour cream
 1 green onion chopped","In a medium sauce pan, melt cheddar cheese part way (until it’s mostly soft but still clumpy) then add the sour cream. Melt and stir until the mixture is smooth. Add the red pepper powder and stir until evenly integrated. Add kimchi and simmer until evenly mixed and smooth. The liquid from the kimchi may give the appearance that the queso is chunky, continue heating and stirring 5-10 minutes and it will smooth out. Serve garnished with chopped green onion. Goes great with chips, raw vegetables, or straight into the mouth via spoon.","cgj4kMm2m9o","Cheese");
SELECT * FROM tastyapp.recipe;