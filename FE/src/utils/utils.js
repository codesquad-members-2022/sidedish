const checkError = async response => {
  if (response.status === 200) {
    const data = await response.json();
    return data;
  } else {
    throw new Error('Fetch Failed');
  }
};

const fetchData = async url => {
  const response = await fetch(url);
  return checkError(response);
};

export { fetchData };
