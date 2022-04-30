async function getFetchData(url) {
  const res = await fetch(url);
  const data = await res.json();
  return data;
}
async function fetchCategories() {
  const data = await getFetchData('http://3.37.71.175:8080' + '/categories?isEvent=false');
  const categories = data.categories.filter(category => category.children.length > 0);
  return categories;
}
async function fetchEventCategories() {
  const data = await getFetchData('http://3.37.71.175:8080' + '/categories?isEvent=true');
  const eventCategories = data.categories[0];
  return eventCategories;
}
async function fetchDishes() {
  const dishes = await getFetchData('http://3.37.71.175:8080' + '/dishes');
  return dishes;
}
async function fetchDishItem(dishId) {
  const dishItem = await getFetchData('http://3.37.71.175:8080' + '/dishes' + `/${dishId}`);
  return dishItem;
}

export { fetchCategories, fetchEventCategories, fetchDishes, fetchDishItem };
