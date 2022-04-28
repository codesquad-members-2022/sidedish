export async function fetchData(url) {
  try {
    const response = await fetch(url);

    if (!response) {
      throw new Error('api failed');
    }

    return response.json();
  } catch (error) {
    throw new Error(error);
  }
}
