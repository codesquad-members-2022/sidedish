export const getData = async (url) => {
    const response = await fetch(url);
    if (!response.ok) {
        throw Error(response.statusText);
    }

    const data = await response.json();
    return data;
};

const getRandomInt = (min, max) => {
    min = Math.ceil(min);
    max = Math.floor(max);

    return Math.floor(Math.random() * (max - min)) + min;
};

export const getRandomKey = () => {
    const alphabet = "abcdefghijklmnopqrstuvwxyz";
    const number = getRandomInt(1, 5);
    const key = [];

    [...Array(number)].forEach((_) => {
        const randomNumber = getRandomInt(1, alphabet.length);
        const booleanValue = getRandomInt(0, 2);
        const randomCharacter = alphabet[randomNumber];

        if (booleanValue) {
            key.push(randomCharacter.toUpperCase());
        } else {
            key.push(randomCharacter);
        }
    });

    return key.join("");
};
