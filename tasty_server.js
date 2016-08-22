var express = require('express');
var app = express();
var port = 8000;
var mysql = require('mysql');
var http = require("http");

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'jsTasty',
  password : 'jsTasty'
});


app.get('/video',function(req,res){
	var video_link = req.query['link']
	var x=req.query['width']
	res.send('<iframe width="'+x+'" height="'+((x/16)*9)+'" src="http://www.youtube.com/embed/'+video_link+'"frameborder="0" allowfullscreen></iframe>');
})

app.get('/main', function (req, res) {
	connection.query('SELECT RecipeId,recipe_title,recipe_image,recipe_description from tastyapp.recipe', function(err, rows, fields) {
	  if (err) throw err;
	  	res.send(rows);
	  	console.log("main request");
	  });
});

app.get('/favorite', function (req, res) {
	var recipe_id = req.query['recipe_id'];
	connection.query('SELECT RecipeId,recipe_title,recipe_image,recipe_description from tastyapp.recipe where RecipeId='+recipe_id, function(err, rows, fields) {
	  if (err) throw err;
	  	res.send(rows);
	  	console.log("favorite request");
	  });
});

app.get('/recipe', function (req, res) {
	var recipe_id = req.query['recipe_id'];
	connection.query('SELECT * from tastyapp.recipe where RecipeId = '+recipe_id, function(err, rows, fields) {
	  if (err) throw err;
	  	res.send(rows);
	  	console.log("recipe request");
	  });
});

app.get('/category', function (req, res) {
	var name = req.query['name'];
	connection.query('SELECT RecipeId,recipe_title,recipe_image,recipe_description from tastyapp.recipe where recipe_category = "'+name+'"', function(err, rows, fields) {
	  if (err) throw err;
	  	res.send(rows);
	  	console.log("category request"+name);
	  });
});

app.get('/search', function (req, res) {
	var name = req.query['name'];
	var cat = req.query['cat'];
	if(cat!=""){
		 cat='and recipe_category = "'+cat+'"';
	}
	connection.query('SELECT RecipeId,recipe_title,recipe_image,recipe_description FROM tastyapp.recipe where (recipe_ingredients like "%'+name+'%" or recipe_description like "%'+name+'%")'+cat, function(err, rows, fields) {
	  if (err) throw err;
	  	res.send(rows);
	  	console.log("search request"+name+"/"+cat);
	  });
});




app.listen(port,'0.0.0.0',function(err,res){
	if(!err){
		console.log('server starter on port '+port);

	}else{
		console.log(':(');
	}
});