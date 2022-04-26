export const getData = async (url, callback) => {
    const response = await fetch(url);
    if (!response.ok) {
        throw Error(response.statusText);
    }

    const data = await response.json();
    callback(data);
};
