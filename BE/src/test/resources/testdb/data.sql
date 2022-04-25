INSERT INTO discount_policy (discount_rate, policy_name)
VALUES (10, '런칭특가'),
       (20, '이벤트특가');

INSERT INTO delivery_policy (delivery_info, delivery_charge, free_delivery_over_amount)
VALUES ('서울 경기 새벽 배송, 전국 택배 배송', 2500, 40000);

INSERT INTO product (discount_policy_id, delivery_policy_id, product_name, description,
                     original_price, meal_category,
                     best_category)
VALUES (1, 1, '오리주물럭', '감칠맛 나는 매콤한 양념', 15800, 'main', 'meat'),
       (2, 1, '잡채', '탱글한 면과 맛깔진 고명이 가득', 12900, 'main', null),
       (2, 1, '소갈비찜', '촉촉하게 밴 양념이 일품', 28900, 'main', 'meat'),
       (null, 1, '간장 코다리조림', '쫀득한 코다리를 국내산 간장소스로맛있게 조렸어요', 14900, 'main', 'season'),
       (2, 1, '한돈 돼지 김치찌개', '김치찌개에는 역시 돼지고기', 9300, 'soup', 'meat'),
       (2, 1, '된장찌개', '특별하지 않아서 더 좋은 우리맛', 8800, 'soup', 'easy'),
       (2, 1, '미역오이냉국', '여름엔 시원한 냉국이 최고', 7800, 'soup', 'season'),
       (null, 1, '동태찌개', '겨울철 보양식으로 안성맞춤', 12000, 'soup', null),
       (1, 1, '새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', 7500, 'side', 'kids'),
       (2, 1, '호두 멸치볶음', '잔명치와 호두가 만나 짭쪼름하지만 고소하게!', 5800, 'side', 'kids'),
       (2, 1, '한동 매콤 안심장조림', '촉촉하게 밴 양념이 일품', 6900, 'side', 'easy'),
       (2, 1, '야채 어묵볶음', '첨가물 없는 순수어묵과 야채와 만남', 4900, 'side', 'easy');


INSERT INTO product_image (product_id, image_url)
VALUES (1,
        'https://s3-alpha-sig.figma.com/img/33bc/7060/2cdf7235b65a114abff05b9133f90085?Expires=1651449600&Signature=GkIDXNQYgylWHG6s0156N~naar2gkF38JhOATAhWKeeHbRT-kL2ijeaFLLZOKSD73FeHAN9qEVDVseXH4fvzR~936Jydsw4S8W7DsU4IBU48TMJdv~VpUo9~W-OHQu68L~rB5n3ol0VvEX1eJAzJqmotiVC1GSRtcpwjzg4DpUKkhnmfDs7j0lP9a7ggNSZdyCxs85cOYFqSwPAOOK~CeL~iO8a9kvq24BzQIlHkIwBVZ4cZQy43TAj4S-Cy3Nu8ck6NVmyi9HHIdKpWzxN0E6sTTPtmgsvoItVvpqpK9DbkaTMwdxj16-AraqhH36l0zqFeKBJslCXkq-9XXIxJAw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (1, 'https://cdn.mkhealth.co.kr/news/photo/201903/img_MKH190315003_0.jpg'),
       (2,
        'https://s3-alpha-sig.figma.com/img/30c6/1007/aaf0c1caf699925cb0a0c2c69d82e2e5?Expires=1651449600&Signature=I8erBK8BzTiT1nrW5ofa4hPVjICOYyFxKVXurOFC6FO7q6SMSLfSY75Vm2gupcOrp5h67leyn9wku8a3SiEHEMO88QIBRORJCkiahnLJeQB739pyBRIk6uKTEKYaWuzKEuwJTqqToxMZVr6r1PmEYJufvuVn0LwAtDSFAYzhaG070m5uLqy0W0-oThvUZIDtD7fIUg0f1thENSbFy7m7neF-t0PedQ5QKA-fk4DFL5tvXKSH5tfv7nyNA6zt8TYNvJ1omyAgkmIornFhocMdvzgfS3m9HjVCimSG4DKEJIxVG-3Tu-iDvFDfbmNZvnTZV5weXCUFixsWk05g0vEFLA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (3,
        'https://s3-alpha-sig.figma.com/img/3088/a859/b9248239edb10b3a2070ffb2266270be?Expires=1651449600&Signature=Y~OB068C3tvFJepjA9l-61ueSOvmJo6lwWIvakUdgVBi4irfitwn0Ux61lOFRW4TMecLKxyuu~gnNXJ-vJVBQ03oG0-8gk31LoQ2ZXjkgR3I44u8aqruEvLvfvHtD1AEnHhhw3TudIwJAj1k-wU2Q3YphUktbeIknILBuzy0qDbHb3qMeX0E2qlORqdZq-mfZKyby0GSnb0ZlfagJVcpBGYO0QnvjCenDMC1RxfirqTtYKkQ4tYkRQiJ7LQRZaxO6tlQBJO91Bn27nJdmKjV6m5-dV3U7WtkhnCA-bM6sKtF-HehOnqtXWkH4oiWiC-lC-9gmrzkHpEn~puLUl6yOw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (4,
        'https://s3-alpha-sig.figma.com/img/1fec/4b6d/3443e6b845e5f50b2c51cd17ada70a2b?Expires=1651449600&Signature=KEhtWjVGkHpR0oNKkc1zgpivn9VYh07Fx~U4mUi~dH-uEkVNCjlhxcdUC1BV~j5CVRRY9My7s-7pxgO2uJuJ49R~mbYjgzT7jnzrredtNSkhPshpZpGFtjXWNI16vSbPk6jlG4kKUCMfOWAB5txdjM0h7udvq1U4oe713~DtCP2rqlC7kGA1acYUFTjeBrjr2zXLrrhg5r3MKG2s7Ow2KvVGPeJ-gzIzEOykJALPqaThO4l6duMcpvB1oDlra1UNDLFWviH7W3ddcDwNH-IHu70LrxCLlnmZFYlCE2K1hfU6XmOJAscJC0a7ERIxtrs-IS0an2mYOi8cMp21xdqWeA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (5,
        'https://s3-alpha-sig.figma.com/img/0c9e/a13d/504616dc9a8935fb641592a22fd79401?Expires=1651449600&Signature=Pmy7iNJH1OV8VmjW6qZmpRzaxt9BlBpZnS2fbN3yLj5sNgB3D5zk3MdtR0zLpauciF0O6ztQezk4FIN7TY63v2KNCOcZUtvVPhk6PohBqTDBYlzBBDVM2h7tIUQIEPnnZlTgGi5GYj3pQcwK2byJTnjfcFqebo-XbEgm04ay2M8CITG68LjHxpk-EAIjDwufn0Ptul9ECRRI9ZR19f6ZeFF5QCy5M9X7igmPSWQIZ4u4v39xZ62sP2CsSFDgnvuZx4m9p6Ix9KwxVZ-rVXrwPxczeZyiUxsR0e1PP1QsEP2ZzJ6bQCbAp8k-kN5BYrDP33OCxw9p2GuBYpgB3YuZWw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (6,
        'https://s3-alpha-sig.figma.com/img/8dcc/f622/373834281eb77763ac930437c6691745?Expires=1651449600&Signature=Qa0oIYtDmNfuoojH74JS9mMGS2C~MGpVZtNT4Pz0Oe~8QMcyPf-gDhaiMta7flI0S-qsM1bZ86KC2MDdJyBgk1QGxroy0p5-F34TZRTigZOuksWXJccmZ~uOYYWLmg-KJtY13bafydrbzPDWoPPVaiefDzR05vsaOQZIr20nxGkbLmk6wsQToqSZs-~dYY3YtsQInlpdHKip~55~GQ2f2EgCaWFiGSAANcjU7~2Wu3sPt5Hq8EIJXIakk1~FVNJbAZCXizyEeYsryK4B92RIgprhhSCIC1zYr8C4Vyj-~Sc~k3FwP16AS00o0l0OYRH8G1RcRd7551mSbO5CGsC4WQ__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (7,
        'https://s3-alpha-sig.figma.com/img/6f61/aff6/7dfc5584cfe6ada2b745dae921e9cd3f?Expires=1651449600&Signature=MMRR~ZZDvAqJiuylePmyY6un8RIzOiew1Uxw1je0O5bAvKl~naXtvG-4yELE7a4ELTG6WuorAw64DEXAd1oUaMKmjUtvudYcxA1MF1kL9RlIiM-DYVIQTzEFOga4LhWGfo4w~bKdUce2UFIeVer4a3PXly9FkHLOBN0qrUwQT1BFp84-q-VPIFhdAgXxhxnlQC3Q0B78i3fxloM6HeTzwhXMclE1IlCQBUcdBbslL8ro0tcVJA0aKSbQTXMxporUFkLjwm2OEUnhs0tbi4XYpzYjXgs4PNSoEcudxbNTwEyZrzvGTfKbxOWc0xgP033EEm0Gx59Nh5GkVife0mUJ4A__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (8,
        'https://s3-alpha-sig.figma.com/img/d0eb/0227/de902d418cca6994236b210596595c62?Expires=1651449600&Signature=NUNX6rx8mah2HZT1o9re5NZdC~2rbN5PtR2uH1Z7Wyl9cT7jjc-~DPFqTc4yvKo6haPD~ckBUBjgnWypE1V5x47vwcHEqyCEyrbuewxi8S64fFFBXlkUFWLNz~QyeTKx62tlJs7DzQneVpf3Os~EfMOcVNoKQ-qA1Wmup1si4PdlxU7ZBl8jmsixbTnWX89O8vgSFmQtNcesNxyfxwBBFFxqQ02yTPmv2lwerBhzzkk~Fspor2iU7TIbO4wIc9GPAQW7ZVFsVkKn4O-6kZMO-iN5ksi41doD-0Oiz7dT6gJFvxjWsrTYbWQdUvYBJduE912f0mCOAFbKi9KR5OVEag__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (9,
        'https://s3-alpha-sig.figma.com/img/2164/9a9b/cd7fc04d16c7a729bbd297e958b5afe6?Expires=1651449600&Signature=Z8Cc3ik8y4FoESTuPAf0S3D~bu~zju2NblwaePrDHDP1yOZF6EwwKZDKjZakWzygG-H7bjs7xg2gHg0fx8Zyjf0NEfea~celLL76-5pyC0TfJhJeOWqcL2hXuZguHb0qQBZvMaHrLCJTSCbDNeD0latWlLgwI~H7qdLjOnMfHyT0iMFJmebeijevY30gg-AC1tqqWcWRbzBBEOlfKULek0pBXzomds8XP5A8EXkpB7TK4IYF-EF5pVSXK57I8aGVOLrXJKfnFpjZpWDPFH~947EsJa46wbZpjlbGLtgSovIfby25bGOvBsNhutbfmuMzPFfvgqiKiKn~rmZUpFtf2Q__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (10,
        'https://s3-alpha-sig.figma.com/img/b395/666f/a6fee6ba7273de06befe048d349f6d51?Expires=1651449600&Signature=QJZEGm5x8umB~qB2qf4Fyd90nvvkQGO9mU64cwzPkpdyYzoPLq0zOJPVVFwBc9zcddMXyVn~0wCQlBnXWNsqDoIsfoGnKaVQafJC0g-TJThT7EGKVuourdj1QIcCZFYHvmdmx843XbDC~yUuaai3Uf9Y5rBECsQJVvsJTKvjvXbNBm7X2lpD8QgPdC2cIAthFUmuo-Z~DNkiK58zgB-g03S022qm5X-16HbuQwxpxGUTOqWJSz2EhWAOZOwNvKfQAVx6yLJRIuTDD2-0A45XhhbO6Pbyp2PTc1aaFvfxMYvTxtxMgaxCW1VG3i2ddRiyJis1uXX6Y2FOpdufN9J39A__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (11,
        'https://s3-alpha-sig.figma.com/img/4a89/69b0/976bacb3c8cd97b9842073864505e391?Expires=1651449600&Signature=IYQMbR~zP1-gP2t56O7eYzIyQoE7vnc29lS66KDVv8tIaF1NWd3A8pmrxPgwTdG5xYdVD9lY9J~6xDgdpxErS1ay3TkV0oHmzAICoGyw4I0zANB-wteTbtwn-gVbw50CGLXP0Ul9yYotUL5GVv~w0aGp6A5MZLlbpDwdDEoMmkkym4O3BjnBUzP9~Ea~5nIjiiyzadOQ6YlQxZ0oUT8x0RazBqJHLTfHKa0e25L9rA5M-g6NOHWIDqxY1jq~ZwV1X-RuAlQLzF51lglo69d~dHlPT4xm9llDqSjMAN8NdO6tWIYGWBtV31zcMzqGQalQ-Edps2lJNceRo8b0KLiUMQ__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA'),
       (12,
        'https://s3-alpha-sig.figma.com/img/e9ec/80a7/4b516aeb7a8a92dbb4d466063ee4f219?Expires=1651449600&Signature=BqIw71fcvf6w2azg2NsgZRiZXUBcwcCZmkSlY3ZsLqaiJVkH5o7X7zmhCqkv-qafWfY8kzN1GAcikn4UJjkCrPgFSVGh5tM-JaUmcWcIGJLxZnQHiF0zUJuvbuHpkVCZV0OXAmgyeK0i6iP70wbg6IS4~hhAiSrLOQHns9VxuWYv5l-k-ItaaW-XgzZcRgVLdgfwjLlMkmRzIainiYpoeQ0w0bYbedYHvYX5StXWtyq9ckIjJw8CEYf4akIhZtZSyXnesKFMZBeouh~VpN9bRqP-Et7wWNmKH7vZFzGTTDXCCLC8~xv5T6giBcGm4sJF0e-pjJoXFT22jOfOdoUTsw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA');
