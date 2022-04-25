export async function fetchData(path) {
  const response = await fetch(process.env.REACT_APP_BASE_ENDPOINT + path);
  return response.json();
}
