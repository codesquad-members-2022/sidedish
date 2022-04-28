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

const handlePostError = async response => {
  if (response.status === 201) {
    setTimeout(() => {
      window.location.reload();
    }, 3000);
    return true;
  } else {
    alert("죄송합니다. 재고가 부족한 상품입니다.");
    return false;
    //throw new Error("Fetch Failed");
  }
};

const postData = async (url, data) => {
  const response = await fetch(url, {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(data),
  });
  return handlePostError(response);
};

const hasClass = (element, className) => {
  return element.classList.contains(className);
};

export {fetchData, postData, hasClass};
