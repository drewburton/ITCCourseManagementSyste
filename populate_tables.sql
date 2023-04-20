INSERT INTO Professors VALUES ('P0000001', 'John', 'Doe', 100000.00);
INSERT INTO Professors VALUES ('P0000002', 'Jane', 'Doe', 95000.00);
INSERT INTO Professors VALUES ('P0000003', 'Bob', 'Smith', 85000.00);
INSERT INTO Professors VALUES ('P0000004', 'Mary', 'Johnson', 90000.00);
INSERT INTO Professors VALUES ('P0000005', 'Tom', 'Brown', 80000.00);
INSERT INTO Professors VALUES ('P0000006', 'Lisa', 'Garcia', 110000.00);
INSERT INTO Professors VALUES ('P0000007', 'David', 'Lee', 120000.00);
INSERT INTO Professors VALUES ('P0000008', 'Karen', 'Davis', 95000.00);
INSERT INTO Professors VALUES ('P0000009', 'Mike', 'Jones', 105000.00);
INSERT INTO Professors VALUES ('P0000010', 'Sarah', 'Wilson', 90000.00);

INSERT INTO Courses VALUES (101, 'MAT', 'Calculus I', false, 3);
INSERT INTO Courses VALUES (102, 'MAT', 'Calculus II', false, 3);
INSERT INTO Courses VALUES (201, 'PHY', 'Physics I', false, 3);
INSERT INTO Courses VALUES (202, 'PHY', 'Physics II', false, 3);
INSERT INTO Courses VALUES (301, 'CHE', 'Organic Chemistry I', true, 3);
INSERT INTO Courses VALUES (302, 'CHE', 'Organic Chemistry II', true, 3);
INSERT INTO Courses VALUES (202, 'ENG', 'Introduction to Creative Writing', true, 3);
INSERT INTO Courses VALUES (402, 'ENG', 'Shakespeare and His Contemporaries', false, 3);
INSERT INTO Courses VALUES (230, 'HIS', 'American History: Revolution to Civil War', true, 3);
INSERT INTO Courses VALUES (360, 'HIS', 'American History: Reconstruction to Present', true, 3);
INSERT INTO Courses VALUES (161, 'BIO', 'Introductory Biology I', false, 3);
INSERT INTO Courses VALUES (162, 'BIO', 'Introductory Biology II', false, 3);
INSERT INTO Courses VALUES (141, 'PSY', 'Introduction to Psychology', true, 3);
INSERT INTO Courses VALUES (460, 'PSY', 'Abnormal Psychology', true, 3);
INSERT INTO Courses VALUES (120, 'ECO', 'Principles of Microeconomics', false, 3);
INSERT INTO Courses VALUES (121, 'ECO', 'Principles of Macroeconomics', false, 3);
INSERT INTO Courses VALUES (127, 'ART', 'Drawing I', true, 3);
INSERT INTO Courses VALUES (232, 'ART', 'Painting II', true, 3);
INSERT INTO Courses VALUES (101, 'MUS', 'Music Theory I', true, 3);
INSERT INTO Courses VALUES (152, 'MUS', 'Music History: Baroque to Classical', false, 3);

INSERT INTO Sessions VALUES (0, 101, 'P0000001', 1, 'M', 101);
INSERT INTO Sessions VALUES (1, 102, 'P0000002', 2, 'T', 102);
INSERT INTO Sessions VALUES (2, 201, 'P0000003', 1, 'M', 201);
INSERT INTO Sessions VALUES (3, 202, 'P0000004', 2, 'H', 202);
INSERT INTO Sessions VALUES (4, 301, 'P0000005', 3, 'MWF', 301);
INSERT INTO Sessions VALUES (5, 302, 'P0000006', 1, 'T', 302);
INSERT INTO Sessions VALUES (6, 202, 'P0000007', 1, 'W', 202);
INSERT INTO Sessions VALUES (7, 402, 'P0000008', 3, 'F', 402);
INSERT INTO Sessions VALUES (8, 230, 'P0000009', 1, 'W', 230);
INSERT INTO Sessions VALUES (9, 360, 'P0000010', 3, 'MTW', 360);
INSERT INTO Sessions VALUES (10, 161, 'P0000001', 2, 'MW', 161);
INSERT INTO Sessions VALUES (11, 162, 'P0000002', 4, 'TH', 162);
INSERT INTO Sessions VALUES (12, 141, 'P0000003', 3, 'W', 141);
INSERT INTO Sessions VALUES (13, 460, 'P0000004', 1, 'M', 460);
INSERT INTO Sessions VALUES (14, 120, 'P0000005', 3, 'TH', 120);
INSERT INTO Sessions VALUES (15, 101, 'P0000001', 1, 'MH', 101);
INSERT INTO Sessions VALUES (16, 102, 'P0000002', 3, 'MW', 102);
INSERT INTO Sessions VALUES (17, 103, 'P0000003', 2, 'T', 103);
INSERT INTO sessions VALUES (18, 104, 'P0000004', 4, 'M', 202);
INSERT INTO sessions VALUES (19, 105, 'P0000005', 3, 'T', 161);
INSERT INTO sessions VALUES (20, 106, 'P0000006', 2, 'W', 141);
INSERT INTO sessions VALUES (21, 107, 'P0000007', 2, 'H', 302);
INSERT INTO sessions VALUES (22, 108, 'P0000008', 3, 'F', 202);
INSERT INTO sessions VALUES (23, 109, 'P0000009', 4, 'MT', 360);
INSERT INTO sessions VALUES (24, 109, 'P0000009', 4, 'MW', 365);
INSERT INTO sessions VALUES (25, 101, 'P0000001', 3, 'M', 301);
INSERT INTO sessions VALUES (26, 102, 'P0000002', 3, 'T', 302);
INSERT INTO sessions VALUES (27, 103, 'P0000003', 3, 'W', 201);
INSERT INTO sessions VALUES (28, 104, 'P0000004', 2, 'H', 202);
INSERT INTO sessions VALUES (29, 105, 'P0000005', 1, 'MWF', 161);
INSERT INTO sessions VALUES (30, 106, 'P0000006', 3, 'T', 141);
INSERT INTO sessions VALUES (31, 101, 'P0000002', 1, 'W', 120);
INSERT INTO sessions VALUES (32, 201, 'P0000003', 4, 'TH', 302);
INSERT INTO sessions VALUES (33, 102, 'P0000004', 4, 'F', 162);
INSERT INTO sessions VALUES (34, 202, 'P0000005', 3, 'M', 201);
INSERT INTO sessions VALUES (35, 103, 'P0000006', 2, 'T', 460);
INSERT INTO sessions VALUES (36, 203, 'P0000007', 4, 'W', 301);
INSERT INTO sessions VALUES (37, 104, 'P0000008', 3, 'TH', 127);
INSERT INTO sessions VALUES (38, 204, 'P0000009', 1, 'M', 101);
INSERT INTO sessions VALUES (39, 105, 'P0000010', 3, 'MTW', 152);
INSERT INTO sessions VALUES (40, 205, 'P0000001', 1, 'W', 120);
INSERT INTO sessions VALUES (41, 106, 'P0000002', 4, 'H', 202);
INSERT INTO sessions VALUES (42, 206, 'P0000003', 3, 'T', 161);
INSERT INTO sessions VALUES (43, 107, 'P0000004', 1, 'M', 141);
INSERT INTO sessions VALUES (44, 207, 'P0000005', 2, 'T', 232);
INSERT INTO sessions VALUES (45, 108, 'P0000006', 4, 'W', 101);
INSERT INTO sessions VALUES (46, 208, 'P0000007', 2, 'TH', 402);
INSERT INTO sessions VALUES (47, 109, 'P0000008', 3, 'F', 201);
INSERT INTO sessions VALUES (48, 209, 'P0000009', 4, 'MW', 162);
INSERT INTO sessions VALUES (49, 110, 'P0000010', 1, 'TH', 460);
INSERT INTO sessions VALUES (50, 210, 'P0000001', 3, 'F', 301);

INSERT INTO students VALUES ('Smit1EZ', 'Emma', 'Smith');
INSERT INTO students VALUES ('John1OZ', 'Olivia', 'Johnson');
INSERT INTO students VALUES ('Will1AZ', 'Ava', 'Williams');
INSERT INTO students VALUES ('Jone1IZ', 'Isabella', 'Jones');
INSERT INTO students VALUES ('Brow1SZ', 'Sophia', 'Brown');
INSERT INTO students VALUES ('Garc1MZ', 'Mia', 'Garcia');
INSERT INTO students VALUES ('Mill1CZ', 'Charlotte', 'Miller');
INSERT INTO students VALUES ('Davi1AZ', 'Amelia', 'Davis');
INSERT INTO students VALUES ('Rodr1HZ', 'Harper', 'Rodriguez');
INSERT INTO students VALUES ('Mart1EZ', 'Evelyn', 'Martinez');
INSERT INTO students VALUES ('Hern1AZ', 'Abigail', 'Hernandez');
INSERT INTO students VALUES ('Lope1EZ', 'Emily', 'Lopez');
INSERT INTO students VALUES ('Gonz1EZ', 'Elizabeth', 'Gonzalez');
INSERT INTO students VALUES ('Pere1MZ', 'Mila', 'Perez');
INSERT INTO students VALUES ('Tayl1EZ', 'Ella', 'Taylor');
INSERT INTO students VALUES ('Ande1AZ', 'Avery', 'Anderson');
INSERT INTO students VALUES ('Wils1SZ', 'Sofia', 'Wilson');
INSERT INTO students VALUES ('Moor1CZ', 'Camila', 'Moore');
INSERT INTO students VALUES ('Jack1AZ', 'Aria', 'Jackson');
INSERT INTO students VALUES ('Mart1SZ', 'Scarlett', 'Martin');
INSERT INTO students VALUES ('Lee1VZ', 'Victoria', 'Lee');
INSERT INTO students VALUES ('Lewi1MZ', 'Madison', 'Lewis');
INSERT INTO students VALUES ('Walk1LZ', 'Luna', 'Walker');
INSERT INTO students VALUES ('Hall1GZ', 'Grace', 'Hall');
INSERT INTO students VALUES ('Alle1CZ', 'Chloe', 'Allen');
INSERT INTO students VALUES ('Youn1PZ', 'Penelope', 'Young');
INSERT INTO students VALUES ('King1LZ', 'Layla', 'King');
INSERT INTO students VALUES ('Wrig1RZ', 'Riley', 'Wright');
INSERT INTO students VALUES ('Scot1ZZ', 'Zoey', 'Scott');
INSERT INTO students VALUES ('Gree1NZ', 'Nora', 'Green');
INSERT INTO students VALUES ('Bake1LZ', 'Lily', 'Baker');
INSERT INTO students VALUES ('Adam1EZ', 'Eleanor', 'Adams');
INSERT INTO students VALUES ('Nels1HZ', 'Hannah', 'Nelson');
INSERT INTO students VALUES ('Cart1LZ', 'Lillian', 'Carter');
INSERT INTO students VALUES ('Mitc1AZ', 'Addison', 'Mitchell');
INSERT INTO students VALUES ('Pere1AZ', 'Aubrey', 'Perez');
INSERT INTO students VALUES ('Robe1EZ', 'Ellie', 'Roberts');
INSERT INTO students VALUES ('Turn1SZ', 'Stella', 'Turner');
INSERT INTO students VALUES ('Phil1NZ', 'Natalie', 'Phillips');
INSERT INTO students VALUES ('Camp1ZZ', 'Zoe', 'Campbell');
INSERT INTO students VALUES ('Park1LZ', 'Leah', 'Parker');
INSERT INTO students VALUES ('Evan1HZ', 'Hazel', 'Evans');
INSERT INTO students VALUES ('Edwa1VZ', 'Violet', 'Edwards'),
INSERT INTO students VALUES ('Coll1AZ', 'Aurora', 'Collins'),
INSERT INTO students VALUES ('Stew1SZ', 'Savannah', 'Stewart'),
INSERT INTO students VALUES ('Sanc1AZ', 'Audrey', 'Sanchez'),
INSERT INTO students VALUES ('Morr1BZ', 'Brooklyn', 'Morris'),
INSERT INTO students VALUES ('Roge1BZ', 'Bella', 'Rogers'),
INSERT INTO students VALUES ('Reed1CZ', 'Claire', 'Reed'),
INSERT INTO students VALUES ('Cook1SZ', 'Skylar', 'Cook'),
INSERT INTO students VALUES ('Bell1PZ', 'Paisley', 'Bell'),
INSERT INTO students VALUES ('Murp1EZ', 'Everly', 'Murphy'),
INSERT INTO students VALUES ('Bail1AZ', 'Anna', 'Bailey'),
INSERT INTO students VALUES ('Rive1CZ', 'Caroline', 'Rivera'),
INSERT INTO students VALUES ('Coop1NZ', 'Nova', 'Cooper'),
INSERT INTO students VALUES ('Rich1GZ', 'Genesis', 'Richardson'),
INSERT INTO students VALUES ('Cox1EZ', 'Emilia', 'Cox'),
INSERT INTO students VALUES ('Howa1KZ', 'Kennedy', 'Howard'),
INSERT INTO students VALUES ('Ward1SZ', 'Samantha', 'Ward'),
INSERT INTO students VALUES ('Torr1MZ', 'Maya', 'Torres'),
INSERT INTO students VALUES ('Pete1WZ', 'Willow', 'Peterson'),
INSERT INTO students VALUES ('Gray1KZ', 'Kinsley', 'Gray'),
INSERT INTO students VALUES ('Rami1NZ', 'Naomi', 'Ramirez'),
INSERT INTO students VALUES ('Jame1AZ', 'Aaliyah', 'James'),
INSERT INTO students VALUES ('Wats1EZ', 'Elena', 'Watson'),
INSERT INTO students VALUES ('Broo1SZ', 'Sarah', 'Brooks'),
INSERT INTO students VALUES ('Kell1AZ', 'Ariana', 'Kelly'),
INSERT INTO students VALUES ('Sand1AZ', 'Allison', 'Sanders'),
INSERT INTO students VALUES ('Pric1GZ', 'Gabriella', 'Price'),
INSERT INTO students VALUES ('Benn1AZ', 'Alice', 'Bennett'),
INSERT INTO students VALUES ('Wood1MZ', 'Madelyn', 'Wood'),
INSERT INTO students VALUES ('Barn1CZ', 'Cora', 'Barnes'),
INSERT INTO students VALUES ('Ross1RZ', 'Ruby', 'Ross'),
INSERT INTO students VALUES ('Hend1EZ', 'Eva', 'Henderson'),
INSERT INTO students VALUES ('Cole1SZ', 'Serenity', 'Coleman'),
INSERT INTO students VALUES ('Jenk1AZ', 'Autumn', 'Jenkins'),
INSERT INTO students VALUES ('Perr1AZ', 'Adeline', 'Perry'),
INSERT INTO students VALUES ('Powe1HZ', 'Hailey', 'Powell'),
INSERT INTO students VALUES ('Long1GZ', 'Gianna', 'Long'),
INSERT INTO students VALUES ('Patt1VZ', 'Valentina', 'Patterson'),
INSERT INTO students VALUES ('Hugh1IZ', 'Isla', 'Hughes'),
INSERT INTO students VALUES ('Flor1EZ', 'Eliana', 'Flores'),
INSERT INTO students VALUES ('Wash1QZ', 'Quinn', 'Washington'),
INSERT INTO students VALUES ('Butl1NZ', 'Nevaeh', 'Butler');
INSERT INTO students VALUES ('Simm1IZ', 'Ivy', 'Simmons');
INSERT INTO students VALUES ('Fost1SZ', 'Sadie', 'Foster');
INSERT INTO students VALUES ('Gonz1PZ', 'Piper', 'Gonzales');
INSERT INTO students VALUES ('Brya1LZ', 'Lydia', 'Bryant');
INSERT INTO students VALUES ('Alex1AZ', 'Alexa', 'Alexander');