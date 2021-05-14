# CS302-Java-2020-Group33
group 33, partII java, COMPSYS302, 2020 s1

The JewelCart application is a jewelry-shopping application that displays jewelry from three 
  categories: Earrings, Rings and Necklaces.
  
Each category is a set of objects of class Products, and its fields are filled up by the 
  EarringsProvider, RingsProvider and NecklacesProvider classes respectively. 
  
The MainActivity page displays the Best-Selling items (populated by a horizontal RecyclerView).
  Any item on this view can be clicked, and redirection will take place to display the selected
  item in DetailsActivity. MainActivity also contains a Search functionality that searches for 
  an item based on the name. If one of the search results is clicked, the selected object is 
  displayed in DetailsActivity. If no products are found, a message is displayed to indicate that 
  the product is not found. 
 
The ListActivity page displays all the objects of the particular category selected in a ListView.
  This page is scrollable, and each item in the list has a picture, a name and a price-tag associated
  with it. Upon clicking any item, the DetailsActivity page is displayed. 
  
The DetailsActivity page displays all the fields of the selected object. The images are filled in
  using the Carousel library, which shows three images per object being displayed. 
