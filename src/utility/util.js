export async function fetchData(url) {
  const data = await fetch(url);
  return data.json();
}
