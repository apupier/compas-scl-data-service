/**
 * SPDX-FileCopyrightText: 2021 Alliander N.V.
 *
 * SPDX-License-Identifier: Apache-2.0
*/

--
-- Adding creation date to the scl_file table.
--
alter table scl_file add column creation_date timestamp default now();
