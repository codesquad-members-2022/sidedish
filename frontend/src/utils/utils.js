const handleError = async response => {
  if (response.status === 200) {
    const data = await response.json();
    return data;
  } else {
    throw new Error("Fetch Failed");
  }
};

const fetchData = async url => {
  const response = await fetch(url);
  return handleError(response);
};

const putData = async (url, data) => {
  const response = await fetch(url, {
    method: "PUT",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(data),
  });
  return handleError(response);
};

export {fetchData, putData};
