export async function fetchData(URL) {
  const response = await fetch(URL);
  const data = await response.json();
  return data;
}
