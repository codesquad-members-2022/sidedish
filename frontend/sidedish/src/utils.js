export const getData = async (url) => {
    const response = await fetch(url);
    if (!response.ok) {
        throw Error(response.statusText);
    }

    const data = await response.json();
    return data;
};
