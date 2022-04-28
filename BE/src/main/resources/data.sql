insert into event (name, description) values ('짱민메인추천1', '짱민이 추천하는 저녁 만찬');
insert into event (name, description) values ('짱짱메인추천2', '짱민이 추천하는 주말 만찬');
insert into event (name, description) values ('짱민국물추천1', '짱민이 고른 술안주 BEST');
insert into event (name, description) values ('짱민반찬추천1', '이것만 있으면 한공기 뚝딱');

insert into category (name, description) values ('메인', '둘이 먹다 하나 죽어도 모르는 메인 요리');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 1, '돼지갈비찜', '먹으면 짱민처럼 멋있어지는 메뉴', 10, 20000, 0.1, '새벽배송', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 1, '오삼불고기', '먹으면 짱민처럼 잘생겨지는 메뉴', 15, 15000, 0.2, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 1, '강남면옥', '비쌉니다', 44, 112000, 0.2, '새벽배송', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 1, '자바칩의정석', '서타벅서', 4090, 7100, 0.2, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 2, '아몬드맛옥수수', '땅콩잼', 234, 10030, 0.2, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 2, '제육볶음', '먹으면 짱민처럼 키커지는 메뉴', 20, 10000, 0.3, '새벽배송', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 2, '김치부침전', '개발자의 꿈을 접었습니다', 30, 4000, 0.3, '전국택배', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 2, '테이프맛껌', '비눗방울입니다', 5, 2000, 0.3, '전국택배', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 3, '전기광선검맛찌개', '품절일걸요', 0, 2000, 0.3, '전국택배', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 3, '보신탕', '디스크립션', 4123, 30000, 0.3, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 3, '까스활명수', '끄어억', 1223, 35000, 0.3, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 3, '꿀맛수박', '대박큼', 123, 11000, 0.3, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 4, '꿀맛참외', '노란색임', 1233, 20000, 0.3, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 4, '꿀맛사과', '빨강', 13, 1000, 0.3, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (1, 4, '꿀맛치킨', '노랑색임', 123, 1440, 0.3, '전국택배', '런칭특가');
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fpost.phinf.naver.net%2FMjAyMjAzMjNfMjI4%2FMDAxNjQ4MDAzNDg5MjUy.eM5dqCsb8dFCfZbHDD-u01rlGPzyjuH_qv9xR0ro89Ig.7ZTaUXtw5JG404DHYk2HFc_t8CdsxfJMx1xE2uqasJYg.JPEG%2FIt5bKJX6vUgjcdW8_BXCFam1Llq8.jpg&type=a340',1);
insert into image(name, dish_id) values ('https://search.pstatic.net/sunny/?src=https%3A%2F%2Fimage.utoimage.com%2Fpreview%2Fcp859895%2F2016%2F11%2F201611002042_800.jpg&type=a340',1);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MjRfMTUw%2FMDAxNjE5MjU0OTUzMjIw.iVakV0VvqMp759BJmRNt17zqPtKJlf0mm5YMJLTfbXYg.MtzTg7EXPhl3sfZTWwQtruvCQkcsnvQeHYu4wIUBH2kg.JPEG.moriharoo%2F20210415_%25B1%25FA%25BA%25C0%25C0%25CC_%2528135%2529.JPG&type=a340',1);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20120127_53%2Fphotofood79_1327653014761RP1Yv_JPEG%2F33111.jpg&type=a340',2);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjdfMjkw%2FMDAxNjQ4MzcyNjgyMDI5.b7-n6IESF_SU5T7hb0gJZt2xzlI-rWWeqRo2RRU0oeEg.RQHPu0yPMPnqUjiOMa_c-NKdONIRjMhUpwuuxuAcIvUg.JPEG.angel951224%2FKakaoTalk_20220327_180226863_06.jpg&type=a340',2);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=https%3A%2F%2Fmodo-phinf.pstatic.net%2F20200902_241%2F1599020697523G2Hfy_JPEG%2FmosacM9wpK.jpeg&type=ofullfill340_600_png',2);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTEyMjhfMTc4%2FMDAxNjQwNjc0MjgzNzI2.0BjFI7xwWEfNb3MKuURws0M_LNwws7Bz3sNtiEvtEEEg.Ei8ULhyGY43b0-d0vxu8NXHGDR7TNDGMJ7RYhmaTfFEg.JPEG.deepof%2F%253DGER_02226.jpg&type=a340',3);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjNfMTA0%2FMDAxNjQ4MDQ3MzMwMzEx.p_sNs1Rzyyp_7AlJ88wwHZgNga2ozrNWGX_JeVRta1Mg.qKVZA-AQSMp8dU0YI72aIv795VAKdG7VPcnsorXZWQog.JPEG.ooevul%2FIMG_1750.jpg&type=a340',3);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA3MjFfMTc4%2FMDAxNjI2ODQwMTIyODUx.LIMKQsMxajdrMmj8y1eTFpTV1PmF136KxCfLPPqj7ycg.BNfEVB3mODYrCeAJ52uKFWbJM211h7v-nN-MaQ9CH0wg.JPEG.misoeun2222%2F1408.jpg&type=a340',3);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMTBfMjYx%2FMDAxNjQ2OTAwMTIxMjA0.hgjbuWKRgJZcuEvk0ouvMXJ0N7DQkoi1NUsCYZm-34sg.9jj9cmPx4kMMQJBrE543506LcL4oiSzKzghZIZlHbFcg.JPEG.abram3000%2FIMG_8008.JPG&type=a340',4);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA1MjJfMjQ0%2FMDAxNTkwMTM1OTUxMzIy.72We2wks7glTDi1VnL3s9W6Iy8lWkYTGAcax_05YIlog.BhX1Kfaldjy_Xi8VP-2Ry5dQN4zydfR0uHbe86d1dyIg.JPEG.kyun8989%2F190521h_%25BF%25DC%25B0%25AB%25C1%25FD_0738.jpg&type=a340',4);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTEyMzBfMTgw%2FMDAxNjQwODI3NjAwMjI2.9ygO0ahTxEz0rd8eRIUP0rmUQuxZ1HHcqOFCcX5n3_kg.OzRFfyzKp-0-0mSDIsF_UR1D-IsTko9otr_nLebINigg.JPEG.misoeun2222%2F0049.jpg&type=a340',4);
insert into image(name, dish_id) values ('https:/https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F421%2F2022%2F03%2F03%2F0005945211_001_20220303183301592.jpg&type=sc960_832',5);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MDVfMjcy%2FMDAxNjQ5MTU2NTI1NDgy.M3aqkiOjraZiaVasIG7kIuOK3geyWCIy02w6UX7WFigg.hdBG8RakIKlcRSsK35-rZEwWOsHzmwkWyk-kFBCdRbgg.JPEG.msinvestment%2F%25C5%25A9%25B1%25E2%25BA%25AF%25C8%25AF220330_%25B4%25DF%25B9%25DF05495.jpg&type=sc960_832',5);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMTRfMjI3%2FMDAxNjQyMTY5Njg5MjYx.uzNMscMY_w6Uo80y2qIqDKG-BBqZmlUJqK0-RnTu1nUg.zLh0nn7f7cJSZ_R_nfHQfjMidMDOiw6QWnQCMmO14OEg.PNG.soomskin%2F20220114_231213.png&type=sc960_832',5);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MjFfMjU4%2FMDAxNjUwNTE0NDc1OTI1.SDys-cDzzdkNwan-ihQ1EehM7Q9LoZPd3v3O0h23G7Mg.0d-yO3i-7RPlHX8umhhAACWtee8B_fq78g4j8ImSeLcg.PNG.dbsgoehs5%2F36.1.png&type=sc960_832',6);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMzFfMjQz%2FMDAxNjQzNjE5MjIxMzAw.Zagqgpl4y3s9TcSJULTliYL74U3m31xvZpFf810wbIYg.4pdjW8_Gzy7kp4eqvIxB_Zo1mt-9oigsZJHeQtv7RTAg.JPEG.kmj9618007%2F1643619209761.jpg&type=sc960_832',6);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMTRfNTUg%2FMDAxNjQyMTUyNTU3MjE4.5kZfy1ny7fyj5_1LYOQKX8H6mjjHhuxcgDRrXgurXoAg.WNprSFHah_c1k_VoQIhjmAlr8J3sq99LpajFgeUfUFIg.JPEG.abram3000%2F3.jpg&type=sc960_832',6);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMjJfMTEg%2FMDAxNjQ1NTE5OTU0Mzg1.8ToU02pF17Xl5sh7Y6YbSCzPcsHsI2Y24CWg5oYmI1Mg.LQMDdFJhN5cGqA_E2UH_l3AZllRsPl_K4X4QqvCxPYYg.JPEG.motiveinno%2F%25B3%25AC%25C1%25F6%25C2%25DE%25B2%25D9%25B9%25CC2.jpg&type=sc960_832',7);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F112%2F2022%2F03%2F04%2F202203040710493479451_20220304071501_02_20220304071701522.jpg&type=sc960_832',7);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MjFfMjc5%2FMDAxNjUwNTQzMzgzOTc2.XFQh0Asiu4LKYKaSbNFEhskQB3k4TujiPYw7RJaWV-8g.fPcBf6q8r5Xj3xEK3esTEwd5iRE4KHdqFxeNdXYgQvEg.JPEG.wldjs0113%2F20200927_113309.jpg&type=sc960_832',7);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMDJfMTE1%2FMDAxNjQzNzcyMzM1NjE3.UVXbxx-tRotcY0P6wTOqEqwj5YWIKdfdOtHxLiE_EPgg.-pq9oIirpW7JTQlPqMuaN6qRtp4LZC_DVusTzW_e1C0g.JPEG.timetofly072%2FSNOW%25A3%25DF20220201%25A3%25DF010058%25A3%25DF386.jpg&type=sc960_832',8);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MThfMTM0%2FMDAxNjUwMjU5MTIzODk2.XlGKroW6xzP4ZV3IFcfTWVVrh1NEh0W25fp_SwC6xQsg.YB6v320euBz3kNXmOMJMetwBflgpU2HSLjiRMOieZQYg.JPEG.rnjsdudal01%2F20220415%25A3%25DF115013.jpg&type=sc960_832',8);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMTBfMjM2%2FMDAxNjQxNzk0Nzc2NTI2.Es0IDUoYO2wvrDvfHd0elC-DVDOg3lOV1asMzU9-O70g.0Jjd79DmAwPpTiGjdwsqRrKrC66U1qVwb_fyrgO5g08g.JPEG.kaemi0309%2FKakaoTalk_20220110_145722044.jpg&type=sc960_832',8);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMTVfMjI4%2FMDAxNjQ0OTE5NDA1ODY2.ILI-XQopchey5e3sEWWGekfSoY1qK8l-FHFBNZP9Kkcg.8We9duFoZTZIWqO9rVBJIL0jNNWw3xGxYbByGvh',9);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MDRfMTE0%2FMDAxNjQ5MDc5NTUxMjk5.iInSX6Meu5TcGtZWAeEToRJB2yU2F-sok-ZqIxGX-AQg.nGyJb5ioHmeOGTsmBFG4-_UruHb3bZvIyag3Rw8sENQg.JPEG.dnvkd%2FDSC03386.jpg&type=sc960_832',9);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MDVfMTQz%2FMDAxNjQ5MTM4NjQ3Nzkx.euqceIUZUM5VkfiLA4bjXlwteebwEFPwGYyaww49WrMg.8-zHagrF7rG9IwvYu7VO4mqXWiZTU8yL8c7rdMiyr8Mg.JPEG.wonsay%2F1649138643443.jpg&type=sc960_832',9);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjdfMjkw%2FMDAxNjQ4MzgyOTUwMTAz.Vt__jXs4TN5YmiNOJC6__96aJQWgZ5TaILnSnmbCTXYg.OMmfQrt9LlI83y0ygFmU0z7sTJ12bcnOkNS5mYrd4XMg.JPEG.jidori0825%2FDSC02973.JPG&type=sc960_832',10);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMTdfMTYx%2FMDAxNjQ3NDgyODk5NDY3.fWysCrC54NHdi8X-i43eoawYwl9RZcInmce9TZvR5Ucg.k-KaXKr4vaAE8p-8i5mZ4hArJbxAbwpl65RFzO-qMkcg.JPEG.hwayeonsz%2FIMG_9138.JPG&type=sc960_832',10);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MTJfMjc3%2FMDAxNjQ5NzM1MTY4MDg5.6WpDm_uFHl8Jprw1ZEeiFtf-WeVi-4Fw7D5vqB7baPAg.0OF5b7XSIuoXbidlwkD0S81v1lr5yq-7O04E27vmQ90g.JPEG.rlqjawkd98%2FKakaoTalk_20220412_121909703_25.jpg&type=sc960_832',10);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MjFfMTk2%2FMDAxNjUwNTQzNTMwNTEz.iiklo-CiDMGREgeS20z8bOpvcbkRBMQJ_GcMWUeKeFQg.cfxxPU9E6lHQjSGKucyo7Ol1cJoMIAZ7zGpGg_5DZ-sg.JPEG.silversun__%2FIMG_5489.JPG&type=sc960_832',11);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMTJfNzgg%2FMDAxNjQ0NjI0MzA2NTc4.9r_yJCIPSq7CL5fW58bHPqy3ZTBZbXdKqgC_8P5uv_4g.HIW3DuS3gZcCiQ4YU3PF2e93quVaVBmQhpEewwuxK2kg.JPEG.marinwith%2F20220211%25A3%25DF181705.jpg&type=sc960_832',11);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MThfMTgg%2FMDAxNjUwMjY1NjM4Mjkw.H3FoQTcIZr1nhJwlf-nSPVybFBeM-S-BYGoZlU6wVe8g.bMFN727T2XDGUDyqfBL4Pfsc8Jao4uUuAXthrS605Jwg.JPEG.yearin_elly%2F20220307%25A3%25DF130437.jpg&type=sc960_832',11);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MDZfMjkx%2FMDAxNjQ5MjI3NjIwMDk5.3XgN6TPOpdF24wMu69MHMsEyFOIiEbnm-zzblP1Z2SUg.q9ktJBmoC09xM-QHOKuDpSOwBKII-P-7QJfZ1iPv-xsg.JPEG.design1229%2FKakaoTalk_20220406_111225559_19.jpg&type=sc960_832',12);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MjFfMjEy%2FMDAxNjUwNTI5MjcxNjcx.mGZQFqm6c8gTRAjUyg3b6MsYKS302VhItdTmbuPQAFMg.QDB9fQnejcjjs9AoNFVKo-yRjFeKGS_xJPwSAKwapZ8g.JPEG.epoon2%2F20210521_121926.jpg&type=sc960_832',12);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MTBfMTU1%2FMDAxNjQ5NTY2MDY4Mzgx.g6--ybMkxntGqjo59TysRdWZRPYTgGa3L4hvxAqPVIgg.mRI_09kWkFE5cOHcYcwgKa0qb4YrbdSOy-Z4qyX5xLkg.JPEG.tjstnr32%2F20220406%25A3%25DF113533.jpg&type=sc960_832',12);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MTJfMTMg%2FMDAxNjQ5NzE4MjQwOTMz.Ybq8xN8nrh0VJ7L94zd-NKg_r_9b_AFBs8a-D_TaX08g.8Xlk3Ms210fl2j30f7q9pAgi_eu0IUQXlrif3ofxTH8g.JPEG.hahong0112%2F1649718239945.jpg&type=sc960_832',13);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMjRfMTI3%2FMDAxNjQ1NjgyMTE2MTcx.M-r6JLePXBfg2w4cuzjerACOUv_6tJl9aTxl6DdPXkcg.qt5SQTsu2Xus8IKvRcL7Tk3E2Fk08q_lIlVEArljxZkg.JPEG.skymap02%2FIMG_3219.jpg&type=sc960_832',13);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMzBfMjUz%2FMDAxNjQ4NjM4MDE3MDIw.yizXLYUQ1vK6GmEmvgibvyg2FXBCUO4reByuo4pWqJ4g.szuUntV3s8r68cRgUjYCibit4rzeUCVf4xr5hSKGYnQg.JPEG.mnjstyle%2FIMG_5481.JPG&type=sc960_832',13);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MDlfMjY3%2FMDAxNjQ5NDY1MTc5Nzc3.AvP4uKhDDSwwQ8zRfGiAags0d-t8jYdO8QAp-C-fazgg.yMNffMjMkgN50NtdFPNtC0ms28M_h7em5sLO1H8KjNsg.JPEG.barkingmad%2F20220408%25A3%25DF184522.jpg&type=sc960_832',14);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MTRfMjQ4%2FMDAxNjQ5OTM3Njc3Nzg0.Xt8t1zDDVbOgq-1cF0R1mTpVGvo6nETZLGqkjxKBLOsg.6BdogMYjoJjKhVPLY3hqBGDLsK4unFpiYJXBbleYEDUg.JPEG.dplovesj%2F20220414120910%25A3%25DFIMG%25A3%25DF5423.JPG&type=sc960_832',14);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MDFfMjE3%2FMDAxNjQ4ODA2NzI4MTI1.f1hBe2Q43c-8wshCc2JzBVoiI_HQsJnPcx3I-7oQ2EUg.ul8TUDZitqCrhVEaCw_sSuvTPbo-1-6RhFBPx7LAUg8g.JPEG.dpwls9506%2F1648806718228.jpg&type=sc960_832',14);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMjhfMzAg%2FMDAxNjQzMzQ2NDg1ODgz.3Cxfyn5PPazIJ33t93Bl_Ou85JXKMDoVhJH5ovRawygg.Zf6SkvLQufGbcQQrueKJN3rWCqUYH7EYpMtoy8AjJWgg.JPEG.eq7979%2FIMG_5437.jpg&type=sc960_832',15);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMTBfMTIg%2FMDAxNjQ2OTEzMjAyODI3.vdCQwS2pCjK_jMtmD0GfF41avrDH-wZYTXvsI1ibh_4g.KZpgwoDo8a5nMZ_0sR03EcHInuwRT6mY_yHjZIcLg6Ag.JPEG.yho54321%2FIMG_6066.jpg&type=sc960_832',15);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMDRfMjU1%2FMDAxNjQ2MzU0MTk4MzA5.AMQiQjPi7qMBGQZI8ajOp6jASqRrqNDETS5T3guGprIg.nTceh_A-MOcf4dgvmgnA-CAN0nYFV92h8OokzR7bFW4g.JPEG.jsr0806%2FIMG_9630.jpg&type=sc960_832',15);


insert into category (name, description) values ('국물', '정성이 듬뿍 담긴 국물 요리');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 1, '해물탕', '먹으면 짱민처럼 존잘되는 메뉴', 1, 19900, 0.3, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 1, '부대찌개', '먹으면 짱민처럼 존잘되는 메뉴', 100, 12900, 0.2, '새벽배송', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 1, '순두부찌개', '먹으면 짱민처럼 존잘되는 메뉴', 3, 8900, 0.1, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 1, '닭볶음탕면', '닭도리탕아닌가요', 555, 12300, 0.1, '새벽배송', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 2, '치킨찌개', '누가사먹음ㅋㅋ', 123, 20200, 0.66, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 2, '부츠찌개', '제대로 보신게 맞습니다', 33, 1100, 20, '새벽배송', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 2, '김치부대찌개', '예아', 55, 8900, 0.1, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 2, '무슨무슨찌개', 'ㅎㅎ사주세요', 569, 123451, 0.1, '전국택배', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 3, '감자피자찌개', '굿', 0, 3424, 0.3, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 3, '미소찌개', '일본', 34, 9900, 0.5, '새벽배송', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 3, '멸치찌개', '멸치가들어간찌개', 89, 13454, 1.5, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 3, '계란말이찌개', '어디에도 없습니다', 4, 24000, 1.7, '새벽배송', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 4, '햄버거찌개', 'ㅎㅎ', 3333, 300, 0.1, '전국택배', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 4, '찌개페스티벌', '쌈바', 134, 5556, 0.1, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (2, 4, '저팔계찌개', '짜글맨', 903, 8900, 0.1, '전국택배', '런칭특가');
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMjBfNTkg%2FMDAxNjQ1MzQ5NTk3NjQ0.C1ShxGLfe06UWtSYtZjAb4fVQBQWrU3R77_nUYeZdGkg.1AKkW39qpWFb7wlwZqdUXok--ZpdKxw44ZVXUUt4Skog.JPEG.dufgkstl%2FIMG_8988.jpg&type=sc960_832',16);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMDdfMTY5%2FMDAxNjQ0MTYyMjc5NzM0.H9sSbMoBQNLUFaXXK3ki2ZlKKVSNigD2aH-PJa6OOM0g.C59hmscrW4VY_BZgzO6R59eNoynJnYKH7r1pLppljAcg.JPEG.dpqms1234%2FDSC09377.JPG&type=sc960_832',16);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMTdfMTAw%2FMDAxNjQ3NDg3MzQwNzI1.jYk0tdcEjQ6RpiKCzbWR7rZ_W2ZLk7yzCcFnwsv1Skcg.ETNBjmMwf0Hx82OCJ1xFcmR4OayEpqwKwRNP9DLGuywg.PNG.hmkhmk99%2Fimage.png&type=sc960_832',16);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjdfMjE2%2FMDAxNjQ4MzkxNzkzOTcx.ppyN9D2LpXLvPG3PtS_zprJjWW4ILPy55_YIesz0idYg.3PS7VMM9AUWMsUwMHelK0r6eVw3bdib2Qc3g9vEsDsAg.JPEG.givenzero2%2F20220326%25A3%25DF174030.jpg&type=sc960_832',17);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjNfMjA1%2FMDAxNjQ4MDEzOTM1OTgz.42I6fCL4pCyBJXJPSn0R5cgQB9zR2ZudOjlBelnmh8Ig.8SlmAulSjEQNyTImBUgryexh90vy1X0RonqknbdUyXUg.JPEG.jina6348%2F1648013931779.jpg&type=sc960_832',17);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MTFfMTAg%2FMDAxNjQ5NjMwNjExMzM0.chnotegIIkhNDN0kGHUWV1ZepJljGbQm4PsER3RyGbAg.njjJ-7C2bxo6VzzYOzNL1_fPjxpKOS2Uj1ir8MfiBfwg.JPEG.sh0408_%2FIMG_8002.jpg&type=sc960_832',17);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMDZfMjAx%2FMDAxNjQ0MTU2MDY2OTg2.AktGXTsst-s8w68yoHtHXt9dyjEC_LMEgKX7lCsF-KAg.ysdGM4wC4sYACtu4P5SpIIJsL_HpB0vIn7PxVGKLHlsg.JPEG.mxxmo%2F1644155904223.jpg&type=sc960_832',18);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMTVfMjE5%2FMDAxNjQ0ODg2NTM2NzMw.wflVjb1o8ZVhB0cggRJuP_vDqQVH98qBqHLJovQa0Tgg._AlDms5a-C0fVEv0LMHuHU21xyka_uqsEaQXyCi7rqsg.PNG.hsjhsjp%2F20220215_095413.png&type=sc960_832',18);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMDNfMjI0%2FMDAxNjQzODE1Mzg3NzA5._9Y-j2LgJq4f9o84hSL8dRZAnuUkeAN0ja8788XyhqAg.FxIiREe22Xtzs-enXC0cs1z3xe14bCmb6GCIOEkMDgIg.JPEG.rudia9308%2FIMG_7901.jpg&type=sc960_832',18);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA0MThfNzYg%2FMDAxNjUwMjgwMTk0Nzk1.TWGl-ys2AhcjdxOh0-3ikcXuGdTvlhXa4FNhkUXnsGIg.im1UbwUPQSx7hPzGJzGsgiNp0UuurXMZ6Nf0CqFB0uMg.JPEG.yesno610%2F20220413%25A3%25DF125009.jpg&type=sc960_832',19);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMTBfMTcx%2FMDAxNjE1Mzg3MTA3Mzgw.dqXmx9kedEgeuGxXq5ItLt7wuYltXcHUbXdp-1kVqdIg.Tot1UzA27EQxDDfa3IThOh1FmHcoP5IY3jfv8T4RNV8g.JPEG.whao33%2F20210310%25A3%25DF203446.jpg&type=sc960_832',19);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMDJfMjUx%2FMDAxNjQzNzg5Mzk1Njcz.aOePDdMEhWYhUV9BPsHXYxSenujro83j_hyANpg_FP8g.ILbwKii4r9H9_yXanzeIMpBF8r-JsY25h0agUvY7UMMg.JPEG.wonjung8542%2Foutput_3986827168.jpg&type=sc960_832',19);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMjdfMjg2%2FMDAxNjExNjg1OTQwMzA1.rGITxgn3QtacIaoDQKT7RdiQ41R6UnxKmJ7RqZ5DO28g.hDGJ0kG5F91UuuWAgQeSwA-UqU1NHgUvzQ8vzraEvREg.PNG.youandme1314%2FIMG_9925.png&type=sc960_832',20);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA3MjhfMTgy%2FMDAxNjI3NDU1NzczMjA2.d1lb8nJaNcL4ec3X33YmYLsl_Ks_ok1doukvqjgSWhsg.Rt-vj43pu7FK9Di3-6iltXZKtqigwoCVP60O3pcMYnMg.PNG.rodastudio%2F%25BC%25F6%25C1%25A4%25B5%25CA_01_%25C2%25FC%25C4%25A1%25BB%25E7%25BD%25C3%25B9%25CC_%25C6%25F2_002_copy.png&type=sc960_832',20);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA3MDhfMjc4%2FMDAxNjI1Njc1NTM4MjEz.Fcmp8yo2jCGbm8kegkKWcfD0jjPQILUHRDw3LNeXBCYg.nCVc31PsD9Xf33hrgmUelihdJCfKoFnFu_TXNFpXOOwg.JPEG.silentsin%2Fphoto_2021-07-08_01-30-36.jpg&type=sc960_832',20);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMTZfMTQ0%2FMDAxNjEwNzg3NzM1NDI4.BpEpP7WJigBTiGRmWFDaYjwKb5b8B-RYwcO-Gr75aiEg.24OjLTu_SoTTFSXMmJ9SWAqi6qUaqOqu_7Wt7Hu_lg4g.JPEG.tngkrhdwn%2FIMG_8259.jpg&type=sc960_832',21);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA4MDNfMTM3%2FMDAxNTk2NDYzNzU3MTU0.Rncg0Z7WvkRJW9ktHB2B4fiH4bHoGCtkHuAGaU74uVQg.U8feFL6Trck_upSqsQM4IyOFMcbf24qmsAGKvp1ibCkg.JPEG.ssktoday%2F1596463755101.jpg&type=sc960_832',21);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA1MzFfMTc3%2FMDAxNTI3NzQ4NjMzNTY3.DG3akCkoSIX4R58YCblfflYsuypQL8qDgKzB6IR8DMkg.yluUJBTHxv6gWOOJXpfrTbaPxLT-jV_OB6Ni6EwCY_Mg.JPEG.jihoon3864%2F%25BC%25F6%25C1%25A4%25B5%25CA_ER%25BE%25C6%25C0%25CC%25BD%25BA%25B0%25ED%25B1%25B8%25B8%25B6_23.jpg&type=sc960_832',21);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA0MTVfMTgz%2FMDAxNTg2OTU4NzQzMTIy.Z-SeteeUrKQO9mkI8D-19yPyv3Z-sTfgbiacxRXofyEg.t55F5_2DqwiYrL8OHFsxVSDOJeOVAC7bGbDAu7mHiB4g.JPEG.uniu87%2FIMG_0245.JPG&type=sc960_832',22);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA5MjBfNTYg%2FMDAxNTA1ODM4MTY0NzQ5.n1qG4w6Bo2q9V4X3wUPIMq58iFrFciNMZItGQMio6aQg._FE4274hidlVj6VQ-p4fZNv1YJDnxCNRMsvRRaSiENcg.JPEG.studiosoom%2F014.jpg&type=sc960_832',22);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA4MDZfMTk2%2FMDAxNTMzNTIwODA4NDUx.TcsSw_2lSy01tmBlew6MpZ6IdDzWi4ERIlBk4j64ljIg.ILxdyHBEVlrplT-7i-snYmV2YsMEX1DFH9GUS2FErY8g.JPEG.jjun2311%2Fp.jpg&type=sc960_832',22);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAzMDRfNzIg%2FMDAxNTUxNjkyNDc1OTg0.fXqcvo6Skg5uxm3jsjCd03a2AohJoZvD_RSmfC7_d8gg.9GENDLH2f2U72dSxwNLYG3jE-OixsXJQJxf-vz4WNjIg.JPEG.jjun2311%2F51872057_243928416485971_2486802328653468897_n.jpg&type=sc960_832',23);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDAzMDZfMTA2%2FMDAxNTgzNDgwNzk4NzIy.ppcqFIHhhMqseWMO3_mhM3ZZkbT72QuAbv78POYBJX8g.FZk-xKJ2log6B8AW0YrS4B6A31tzG0DhrYT07a5NN6Yg.JPEG.msinvestment%2F022802974.jpg&type=sc960_832',23);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTEwMjRfNzUg%2FMDAxNTcxODc5MDUzNjI3.e0FzWanePkF0dXGNlrXGt1Jp1vwSrvrG00kB3N8BL5og.HZ6_JiO-xi0sSaO3axY855jiBJ1U0veLgQxtwkhKY5Qg.JPEG.dicapoto%2F4F5T8681.jpg&type=sc960_832',23);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA1MDJfMTgx%2FMDAxNTU2NzU5MTYzNTY4.7mfnJtJNjt6N-5c9ZWM3kmQQP--tm9xshsEqAn5x4Ucg.hacGU75ElSxdpUNwJ9tcA76qJDbbPsHO-bfHrS6d3QEg.JPEG.soonhwanstyle%2F%25C7%25C7%25C0%25DA%25B4%25E50097.jpg&type=sc960_832',24);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20160106_75%2Fjjun2311_1452073337165veNTb_JPEG%2FIMG_2005.jpg&type=sc960_832',24);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMTBfMjMg%2FMDAxNjE1MzA1OTMwMDg0.a9l8IDyuNIKmk-1XUtCIOIr5fgxJ-MXBpKKzXZulUBEg.nFlka7c1KFQZe1FdFmwfkGOLDOtpR6nSS8nbJ-WZDLMg.JPEG.urbanestudio%2F1.%25C4%25A1%25C5%25B2_%25BC%25BC%25C6%25AE_1.jpg&type=sc960_832',24);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MjRfMTg2%2FMDAxNjE5MjU0OTYzMjQ1.CQ6JGDQ33ztNf7DFR_anUXRaQ56HRa78ACQ7ioDShUAg.2BGFWLXmQAvKdZE4FaB2MaAylaiW2LaEZaLhcudspeUg.JPEG.moriharoo%2F20210415_%25B1%25FA%25BA%25C0%25C0%25CC_%2528171%2529.JPG&type=sc960_832',25);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA3MzFfMTIx%2FMDAxNjI3NzIxODY1NDkz.LHFRMLVjxZpGRkN7MEVDFOGQG3aw0dBhVhrkDYx8KcEg.PQYheOyINyK0B4l68vE-6ktolaPvsqlaP0fIgCCOLhEg.JPEG.urbanestudio%2F%253F%258C%258C%25EB%25A8%25B8%25EC%258A%25A4015.JPG&type=sc960_832',25);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F016%2F2018%2F11%2F19%2F20181119000171_0_20181119143521889.jpg&type=sc960_832',25);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDExMjBfNjEg%2FMDAxNjA1ODU3MjA3Mjcx.F7kZ24b7OA0NYxkfeH_-XNSB9eA5EohO-sH1PwARO5sg.-NazblCBiRPqduSqvyEBs7Z_fgEdddIAwU2wY5SmD-Qg.JPEG.zzzium%2FIMG_2038.jpg&type=sc960_832',26);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA1MDZfMjcw%2FMDAxNTg4NzU3MTQwNDQ2.KyBmoCp-IMnxrxC801_1Q7sXEKQURsWenEwvdHAL1jMg.jidnOf6JLwqVUFNHGbZh9hPH3xZgK9FpR5BRKbrSqH4g.JPEG.viewbox2800%2Fre_A7R08690.jpg&type=sc960_832',26);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA3MDJfMTAz%2FMDAxNTMwNTMzMDQxOTg1.LCWc7JAhCzK7VpdxJOlCF3vMRRazk58MPfB2AOzR_hAg.r2tF7vK1jr0wcKMU3JsCYIIimSXNkL0BFrVURCOVWlAg.JPEG.jt-studio%2F%25C6%25C7%25B1%25B3%25BD%25BA%25C6%25A9%25B5%25F0%25BF%25C0_%25BA%25D0%25B4%25E7%25BD%25BA%25C6%25A9%25B5%25F0%25BF%25C0_%25BC%25EE%25C7%25CE%25B8%25F4%25C3%25D4%25BF%25B5_%25C7%25C1%25B7%25CE%25C7%25CA%25BB%25E7%25C1%25F8_%25C7%25AA%25B5%25E5%25BB%25E7%25C1%25F8_JT%25BD%25BA.jpg&type=sc960_832',26);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA4MDNfMTcz%2FMDAxNjI3OTU5NDA3OTYw.jjXZWM3H8dxTSDK3on_IP4F_PdeAilPRFX97Srv6KQ8g.d_uZtDqy7ts1rehfx9WoDzMkC_HXVAMJYc9oyaXM_icg.JPEG.photo4782%2F_0008065.JPG&type=sc960_832',27);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=https%3A%2F%2Fmodo-phinf.pstatic.net%2F20210107_21%2F1609946546629HSR8D_JPEG%2FmosaymHdi5.jpeg&type=sc960_832',27);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MTlfMTgg%2FMDAxNjI0MDg3NzIyNDQx.7K0ecnhgB4_mtDElBO0wrLievxG1w_y9tJevN9KAkWQg.TftupybUEHg_4h5lK-ZMYQINb2vGAXWWVeyKxo97DU0g.JPEG.mersher%2F%25C5%25A9%25B1%25E2%25BA%25AF%25C8%25AFIMG_0007_4.JPG&type=sc960_832',27);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20210528_103%2F16221844922711fDBy_JPEG%2F23320327046471080_1847237482.jpg&type=sc960_832',28);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA3MDdfMTYx%2FMDAxNjI1NjQ0NzQ2MTM1.2EyuH2KXart4mvcCja9JwtaceGxHAqYmXr5xFNnTc-cg.4HjdPagphfbNjDQbKLQaqnUEGTmpFJHQSsd4UH3JyqMg.JPEG.foodasb%2F3.jpg&type=sc960_832',28);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20210310_238%2F1615365540593DkV8A_JPEG%2F16501324271865400_1546641208.jpg&type=sc960_832',28);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA0MzBfOTEg%2FMDAxNTU2NjA2NDI1OTYz.7HtzFeSqF189olYP_AAexsTyHluoYBVV1Tsx_JfDxNIg.9ONZwHBL6MUHdVPLdWW0idGH9XT9_SpCNEraa1WM5U4g.JPEG.msinvestment%2FRL9A3477_190430.jpg&type=sc960_832',29);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMTFfMjY3%2FMDAxNjQ0NTY1NzY3NTA5.GkL_MbOj1QErgQ_tt_Ws5wX3LwHGnhilNNgGrQ5OImUg._ECeZsFPRlycANs7Vf25DOXgALsMiHFhpKRazF_oN2og.PNG.hmaru7488%2F20220211_164908.png&type=sc960_832',29);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA1MDVfMTM4%2FMDAxNTI1NDkyNTUwNTcx.FCpgd8T_klA1m9hefmwBr4Chlk8_QhYw84LtWnGd7V8g.R6NOPdXWuoiVvPd2hKvvTu4cJn3aUzKaK7RhnhABNd0g.JPEG.urbanestudio%2F%25C1%25A6%25C1%25D6%25B8%25F3%25C6%25AE%25B6%25F305346.JPG&type=sc960_832',29);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMjVfNSAg%2FMDAxNjExNTU0NTk0Nzc0.kwhkR-JtPkCIvUd62IsxHhlacQjPK0DMj39SxwcWt8wg.dV1F-BR1Dm9vca6otg55mnYGG04yd0DH8tGV2115SYAg.JPEG.msinvestment%2FIMG_1878.jpg&type=sc960_832',30);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDZfOTAg%2FMDAxNjIyOTYyMjc3NTY0.Nt33lsoLb6J-CWSBCB6LUYbWDKJP6NTVByJ0747wW_Ig.ckUzcgUU6akEgCpAm5ICxE9Zrn7pP8azTsBR1OctVY0g.JPEG.msinvestment%2F21060100577.jpg&type=sc960_832',30);
insert into image(name, dish_id) values ('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA3MTJfMjY3%2FMDAxNDk5ODM3Mzg5MjI5.nbQVDvY7XOaT_213kDiSKYf8m3LJsjf5uZ2wMVNchN8g.Bd-_ArNuBqizOZkyplSi6fQdGsteyx7ZqMmDWh9Cp_og.PNG.msinvestment%2F%25C0%25B0%25B0%25A1%25B0%25F8%25BE%25F7%25C3%25BC_%25B0%25ED%25B1%25E2%25BB%25E7%25C1%25F8%25C3%25D4%25BF%25B5.png&type=sc960_832',30);





insert into category (name, description) values ('반찬', '어머니가 해주신 바로 그 맛');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 1, '샌드위치', '꿀맛', 10, 400000, 0.5, '새벽배송', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 2, '쿠키', '잔잔바리꿀맛', 30, 350000, 0.5, '새벽배송', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 3, '찰깨빵', '아주맛있는', 50, 14522, 0.5, '새벽배송', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 4, '성심당소보루', '흔한맛입니다', 14, 55555, 0.5, '새벽배송', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 1, '연포탕', '불백이더맛있음', 100, 66666, 0.5, '새벽배송', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 2, '튀긴신발', '제일맛있음', 100, 45235, 0.5, '새벽배송', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 3, '콜라', '제로드세요', 10000, 13411, 0.5, '새벽배송', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 4, '꼬막비빔밥', '바다의 내음을 싸악', 10000, 12800, 0.5, '새벽배송', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 3, '전주비빔밥', '풍성하게 싸악', 100, 9000, 0.3, '전국택배', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 2, '산채비빔밥', '나물과 고추장 그리고 참기름 싸악', 100, 12000, 0.3, '새벽배송', '이벤트특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 4, '무생채', '어디든지 다 함께 싸악', 100, 9900, 0.3, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 4, '열무김치', '아삭아삭싸악', 100, 9900, 0.3, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 2, '백김치', '맵지않게 싸악', 100, 9900, 0.3, '전국택배', '정가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 1, '참치마요', '참지말고 싸악', 100, 6900, 0.5, '새벽배송', '런칭특가');
insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy)
values (3, 1, '치킨마요', '참치말고 싸악', 100, 6900, 0.5, '새벽배송', '런칭특가');

insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image_readtop_2020_1140065_16046234494420999.jpg',31);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image_readmed_2020_1140065_16046234494421000.jpg',31);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image_readmed_2020_1140065_16046234494421000.jpg',31);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image_readbot_2020_1140065_16046234494421001.jpg',32);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image__2020_1140065_16046234494421002.jpg',32);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image__2020_1140065_16046234504421003.jpg',32);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image__2020_1140065_16046234504421003.jpg',33);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image__2020_1140065_16046234504421008.jpg',33);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image__2020_1140065_16046234504421004.jpg',33);
insert into image(name, dish_id) values ('https://file.mk.co.kr/meet/neds/2020/11/image__2020_1140065_16046234504421005.jpg',34);
insert into image(name, dish_id) values ('http://www.newsprime.co.kr//data/photos/cdn/20220205/art_560564_1643865519.jpg',34);
insert into image(name, dish_id) values ('https://zipbanchan.godohosting.com/detail_page/5_kid/522_ZIP_P_6070_S.jpg',34);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/3_main/730_ZIP_P_0073_S.jpg',35);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/3_main/417_ZIP_P_0041_S.jpg',35);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/5_kid/1422_ZIP_P_5150_S.jpg',35);
insert into image(name, dish_id) values ('https://zipbanchan.godohosting.com/detail_page/5_kid/719_ZIP_P_6113_S.jpg',36);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/5_kid/1159_ZIP_P_3082_S.jpg',36);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/11_jeon_fish/821_ZIP_P_3065_S.jpg',36);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/11_jeon_fish/1081_ZIP_P_3074_S.jpg',37);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/11_jeon_fish/1251_ZIP_C_5031_S.jpg',37);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/7_fry/86_ZIP_P_6008_S.jpg',37);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/13_big/164_ZIP_P_4004_S.jpg',38);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/7_fry/260_ZIP_P_6033_S.jpg',38);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/13_big/168_ZIP_P_4019_S.jpg',38);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/6_jolim/692_ZIP_P_4030_S.jpg',39);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/7_fry/654_ZIP_P_6094_S.jpg',39);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/6_jolim/56_ZIP_P_4009_S.jpg',39);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/6_jolim/67_ZIP_P_4014_S.jpg',40);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/6_jolim/1206_ZIP_P_6221_S.jpg',40);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/6_jolim/1195_ZIP_P_4062_S.jpg',40);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/6_jolim/1332_ZIP_P_4067_S.jpg',41);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/5_kid/1314_ZIP_P_6246_S.jpg',41);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/5_kid/1164_ZIP_P_4061_S.jpg',41);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/8_muchim/1301_ZIP_P_5142_S.jpg',42);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/8_muchim/715_ZIP_P_5064_S.jpg',42);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/8_muchim/1328_ZIP_P_5144_S.jpg',42);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/9_soup/1369_ZIP_P_2043_S.jpg',43);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/9_soup/177_ZIP_P_2002_S.jpg',43);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/9_soup/171_ZIP_P_2009_S.jpg',43);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/9_soup/134_ZIP_P_1007_S.jpg',44);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/9_soup/170_ZIP_P_2007_S.jpg',44);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/3_main/832_ZIP_P_4044_S.jpg',44);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/3_main/350_ZIP_P_0025_S.jpg',45);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/3_main/1337/1337_ZIP_P_0090_S.jpg',45);
insert into image(name, dish_id) values ('http://zipbanchan.godohosting.com/detail_page/3_main/1335/1335_ZIP_P_0091_S.jpg',45);
